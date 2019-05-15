// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 首页轮播图
    swiperList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 获取首页轮播图数据
    this.getSwiperList();
  },

  /**
   * 获取首页轮播图数据
   */
  getSwiperList() {
    let that = this;
    // 利用小程序内置发送请求的方法
    // 公共接口路径：https://easy-mock.com/mock/5c1dfd98e8bfa547414a5278/bili/
    // 首页导航：navList
    // 首页轮播图：swiperList
    // 视频列表: videosList
    // 视频详情：videoDetail?id    需要带上视频的Id
    // 推荐视频：otherList?id  需要带上视频的Id
    // 评论列表: commentsList?id  需要带上视频的Id
    wx.request({
      url: "https://easy-mock.com/mock/5c1dfd98e8bfa547414a5278/bili/swiperList",
      success(res) {
        //console.log(res);
        if (res.data.code == 0) {
          that.setData({
            swiperList: res.data.data.swiperList
          })
        }
      }
    })
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})