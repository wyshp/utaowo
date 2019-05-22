const root = '/utaowo-web/api/';

const API_BASE_URL = 'http://192.168.4.107:8080' + root;
module.exports = {
  IndexUrlBanner: API_BASE_URL + 'index/banner', //首页-banner轮播图

  ResourceUrlVideo: API_BASE_URL + 'index/videoList', // 资源页-视频列表

  AuthLoginByWeixin: API_BASE_URL + 'auth/login_by_weixin', //微信登录

};
