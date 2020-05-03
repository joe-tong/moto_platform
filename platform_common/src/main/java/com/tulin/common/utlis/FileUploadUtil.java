package com.tulin.common.utlis;

import com.tulin.common.base.Const;
import com.tulin.common.base.enumeration.ResponseCode;
import com.tulin.common.excption.BaseException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tpp
 * @date 2018/7/28
 */
public class FileUploadUtil {

    /**
     * 上传图片
     */
    public static List<String> uploadImg(List<MultipartFile> multipartFiles, String path)
            throws IllegalStateException, IOException {
        if (BlankUtil.isBlank(multipartFiles)) {
            return null;
        }
        // 保证上传路径
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        List<String> imageUrls = new ArrayList<>(multipartFiles.size());
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")
                    || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("pneg")) {
                String name = DateUtil.getTimeStamp() + "." + extension;
                File file = new File(path, name);
                multipartFile.transferTo(file);
                imageUrls.add(Const.IMAGE_UPLOAD_RELATIVE_PATH + name);
            } else {
                throw new BaseException(ResponseCode.图片格式不对);
            }
        }
        return imageUrls;
    }

    /**
     * 单个图片上传
     *
     * @param multipartFile
     * @param path
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String uploadImg(MultipartFile multipartFile, String path) throws IllegalStateException, IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        // 保证上传路径
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String imageUrl = null;

		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("png")
				|| extension.equalsIgnoreCase("pneg")) {
			String name = DateUtil.getTimeStamp() + "." + extension;
			File file = new File(path, name);
			multipartFile.transferTo(file);
			imageUrl = Const.IMAGE_UPLOAD_RELATIVE_PATH+name;
		} else {
			throw new BaseException(ResponseCode.图片格式不对);
		}

        return imageUrl;
    }

    /**
     * 上传视频
     *
     * @param multipartFiles
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> uploadVideo(MultipartFile[] multipartFiles, String path) throws IOException {
        if (BlankUtil.isBlank(multipartFiles)) {
            return null;
        }
        // 保证上传路径
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        List<String> imageUrls = new ArrayList<>(multipartFiles.length);
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            if (extension.equalsIgnoreCase("mp4") || extension.equalsIgnoreCase("rmvb")
                    || extension.equalsIgnoreCase("avi") || extension.equalsIgnoreCase("mpeg")
                    || extension.equalsIgnoreCase("flv")) {
                String name = DateUtil.getTimeStamp() + "." + extension;
                File file = new File(path, name);
                multipartFile.transferTo(file);
                imageUrls.add(Const.VIDEO_UPLOAD_RELATIVE_PATH + name);
            } else {
                throw new BaseException(ResponseCode.视频格式不对);
            }
        }
        return imageUrls;
    }

    /**
     * 单个视频上传
     *
     * @param multipartFile
     * @param path
     * @return
     * @throws IOException
     */
    public static String uploadVideo(MultipartFile multipartFile, String path) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        // 保证上传路径
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String videoUrl = null;
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        if (extension.equalsIgnoreCase("mp4") || extension.equalsIgnoreCase("rmvb")
                || extension.equalsIgnoreCase("avi") || extension.equalsIgnoreCase("mpeg")
                || extension.equalsIgnoreCase("flv")) {
            String name = DateUtil.getTimeStamp() + "." + extension;
            File file = new File(path, name);
            multipartFile.transferTo(file);
            videoUrl = Const.VIDEO_UPLOAD_RELATIVE_PATH + name;
        } else {
            throw new BaseException(ResponseCode.视频格式不对);
        }
        return videoUrl;
    }
    /**
     * 删除文件
     *
     * @param imageUrlList
     * @return
     */
    /**
     * 删除文件
     *
     * @param imageUrlList
     * @return
     */
    public static void deleteFiles(List<String> imageUrlList) {
        if (BlankUtil.isBlank(imageUrlList)) {
            return;
        }
        for (String url : imageUrlList) {
            new File(url).delete();
        }
    }

}
