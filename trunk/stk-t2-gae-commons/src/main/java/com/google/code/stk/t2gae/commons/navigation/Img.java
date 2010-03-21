package com.google.code.stk.t2gae.commons.navigation;

import java.io.File;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.t2framework.commons.util.Assertion;
import org.t2framework.commons.util.FileUtil;
import org.t2framework.commons.util.StreamUtil;
import org.t2framework.t2.contexts.WebContext;
import org.t2framework.t2.navigation.StreamNavigation;
import org.t2framework.t2.spi.Navigation;

public class Img extends StreamNavigation {

	private String contentType;

	public Img(byte[] bytes) {
		super(bytes);
		ImgCodec codec = ImgCodec.getInstance(bytes);
		Assertion.notNull(codec);
		contentType = codec.contentType;
	}

	public Img(File file) {
		super(file);
		ImgCodec codec = ImgCodec.getInstance(FileUtil.getBytes(file));
		Assertion.notNull(codec);
		contentType = codec.contentType;
	}

	public Img(InputStream is) {
		super(is);
		ImgCodec codec = ImgCodec.getInstance(StreamUtil.getBytes(is));
		contentType = codec.contentType;
	}

	public Img(byte[] bytes , ImgCodec codec) {
		super(bytes);
		Assertion.notNull(codec);
		contentType = codec.contentType;
	}

	public Img(File file , ImgCodec codec) {
		super(file);
		Assertion.notNull(codec);
		contentType = codec.contentType;
	}

	public Img(InputStream is , ImgCodec codec) {
		super(is);
		Assertion.notNull(codec);
		contentType = codec.contentType;
	}

	public static Navigation jpg(byte[] bytes){
		return new Img(bytes , ImgCodec.JPG);
	}

	public static Navigation gif(byte[] bytes){
		return new Img(bytes , ImgCodec.GIF);
	}

	public static Navigation png(byte[] bytes){
		return new Img(bytes , ImgCodec.PNG);
	}

	public static Navigation jpg(File file){
		return new Img(file , ImgCodec.JPG);
	}

	public static Navigation gif(File file){
		return new Img(file , ImgCodec.GIF);
	}

	public static Navigation png(File file){
		return new Img(file , ImgCodec.PNG);
	}

	public static Navigation jpg(InputStream is){
		return new Img(is , ImgCodec.JPG);
	}

	public static Navigation gif(InputStream is){
		return new Img(is , ImgCodec.GIF);
	}

	public static Navigation png(InputStream is){
		return new Img(is , ImgCodec.PNG);
	}

	public static Navigation from(byte[] bytes){
		return new Img(bytes);
	}

	public static Navigation from(File file){
		return new Img(file);
	}

	public static Navigation from(InputStream is){
		return new Img(is);
	}

	@Override
	public void execute(WebContext context) throws Exception {
		final HttpServletResponse res = context.getResponse().getNativeResource();
		res.setContentType(contentType);
		ServletOutputStream sos = res.getOutputStream();
		super.writeTo(res, sos);
		sos.flush();
	}

	public enum ImgCodec{
		GIF("image/gif"),

		PNG("image/gif"),

		JPG("image/jpg");

		private String contentType;

		private ImgCodec(String contentType){
			this.contentType = contentType;
		}

		public String getContentType(){
			return this.contentType;
		}

		public static ImgCodec getInstance(byte[] bytes){
			if (bytes != null &&
					bytes.length >= 2) {
				int b1 = bytes[0] & 0xFF;
				int b2 = bytes[1] & 0xFF;
				if (b1 == 0xFF && b2 == 0xD8) {
					return ImgCodec.JPG;
				} else if (b1 == 0x47 && b2 == 0x49) {
					return ImgCodec.GIF;
				} else if (b1 == 0x89 && b2 == 0x50) {
					return ImgCodec.PNG;
				}
			}
			return null;
		}
	}
}
