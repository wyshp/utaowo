const root = '/utaowo-web/api/';

// const API_BASE_URL = 'http://fly2you.cn' + root;
const API_BASE_URL = 'http://localhost:8080' + root;
module.exports = {
  AuthLoginByWeixin: API_BASE_URL + 'auth/login_by_weixin', //微信登录

};
