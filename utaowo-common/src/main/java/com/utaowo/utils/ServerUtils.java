package com.utaowo.utils;

public class ServerUtils {

	/**
	 * 服务区项目路径
	 */
	private static String realPath = null;

	/**
	 * 服务器域名
	 */
	private static String domain = null;

	private static String imageDomain = null;

	private static String imageFolder = null;

	public static String getRealPath() {
		return realPath;
	}

	public static void setRealPath(String realPath) {
		ServerUtils.realPath = realPath;
	}

	public static String getDomain() {
		return domain;
	}

	public static void setDomain(String domain) {
		ServerUtils.domain = domain;
	}

	public static String getImageDomain() {
		return imageDomain;
	}

	public static void setImageDomain(String imageDomain) {
		ServerUtils.imageDomain = imageDomain;
	}

	public static String getImageFolder() {
		return imageFolder;
	}

	public static void setImageFolder(String imageFolder) {
		ServerUtils.imageFolder = imageFolder;
	}

}
