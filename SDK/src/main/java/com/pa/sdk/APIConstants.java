package com.pa.sdk;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/9/21
 * @desc   :
 */
public class APIConstants {

    public static final String API_HOST = "http://192.168.0.108/arche/";
    private static final String API_DEBUG_URL = "http://192.168.0.108/arche/api.php";
    private static final String API_RELEASE_URL = "http://api.router.org";

    public static final boolean IS_DEBUG = true;
    public static final String API_URL = IS_DEBUG ? API_DEBUG_URL : API_RELEASE_URL;

}
