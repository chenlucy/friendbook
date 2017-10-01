package com.bojin.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Ajax异步上传图片
 *
 * @author Hang.W
 * @version 1.0, 2017-02-14 00:51:39
 */
@Controller
public class UploadController {

    /**
     * 使用Ajax异步上传图片
     *
     * @param pic 封装图片对象
     * @param request
     * @param response
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("/upload/uploadPic.do")
    public void uploadPic(MultipartFile pic, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {

        try {
            // 获取图片原始文件名
            String originalFilename = pic.getOriginalFilename();
            System.out.println(originalFilename);

            // 文件名使用当前时间
            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

            // 获取上传图片的扩展名(jpg/png/...)
            int location = pic.getOriginalFilename().lastIndexOf(".");
            String extension = pic.getOriginalFilename().substring(location);
//            String extension = FilenameUtils.getExtension(originalFilename);

            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = "/upload/" + name + "." + extension;

            // 图片上传的绝对路径
            String url = request.getSession().getServletContext().getRealPath("") + path;

            File dir = new File(url);
            if(!dir.exists()) {
                dir.mkdirs();
            }

            // 上传图片
            pic.transferTo(new File(url));

            // 将相对路径写回（json格式）
            JSONObject jsonObject = new JSONObject();
            // 将图片上传到本地
            jsonObject.put("path", path);

            // 设置响应数据的类型json
            response.setContentType("application/json; charset=utf-8");
            // 写回
            response.getWriter().write(jsonObject.toString());

        } catch (Exception e) {
            throw new RuntimeException("服务器繁忙，上传图片失败");
        }
    }

}
