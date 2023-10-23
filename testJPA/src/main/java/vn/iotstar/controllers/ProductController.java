package vn.iotstar.controllers;

import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(fileSizeThreshold = 1024*1024*10,  maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*50)
public class ProductController {

}
