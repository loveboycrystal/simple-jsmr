package com.loveboy.commons;

/**
 * 功能id枚举（即Resource 编号）
 * 
 * @author chenes
 */
public enum YHFunction {

	none("99999", "非描述方法"), login("10000", "用户登录功能"), logout("10001", "用户登出"), getDict(
			"10002", "获取壹号课堂字典信息"), getSysUser("10003", "获取系统用户信息"), getSysUserList(
			"10004", "获取系统用户列表信息"), changeStatus("10005", "更新FAQ记录生效/失效状态"), editFaq(
			"10006", "修改FAQ"), listFaq("10007", "获取FAQ列表"), deleteFaq("10008",
			"删除FAQ"), addFaq("10009", "新增FAQ"), addMyLike("10010", "新增我的喜欢"), deleteMyLike(
			"10011", "删除我的喜欢"), getMyLikeByUserId("10012", "根据用户ID获取我的喜欢"), addMySubscribe(
			"10013", "新增我的订阅"), deleteMySubscribe("10014", "删除我的订阅"), getMySubscribeByUserId(
			"10015", "根据用户ID获取用户的订阅"), addPlayHistory("10016", "新增播放历史"), deletePlayHistory(
			"10017", "删除播放历史"), getPlayHistoryByUserId("10018",
			"根据用户ID获取最近播放音频列表"), appLogout("10018", "app用户登出"), appReLogin("10019",
			"app用户刷新登录"), addGiveRecords("10020", "新增赠送记录"), addOrder("10021",
			"新增订单记录"), editOrder("10022", "修改订单记录"), listOrder("10023",
			"查询订单列表"), addBalanceDetail("10024", "新增变动明细"), listBalanceDetail(
			"10025", "获取变动明细列表"), getCounts("10026", "统计用户的已购数、喜欢数、播放历史数"), getByDoubleId(
			"10027", "根据专辑ID、用户ID获取记录,用于判断用户是否已订阅该专辑"), checkLikeOrNot("10028",
			"根据音频ID、用户ID获取记录,用于判断是否已喜欢该音频"), addGoods("10029", "新增商品"), deleteGoods(
			"10030", "删除商品"), listGoodsMgr("10031", "获取商品列表"), editGoods("10032",
			"修改商品信息"), getYhGoodsByType("10033", "根据商品类型获取商品列表"), getGoodsById(
			"10034", "根据商品ID获取商品"), listRewardOrder("10035", "获取打赏记录列表"), listAlbumOrderByUserId(
			"10036", "前端-基于订单获取用户专辑已购列表"), addReward("10037", "新增打赏订单"), listRewardMgr(
			"10038", "获取打赏列表"), editReward("10039", "修改打赏订单"), updateHistory(
			"10040", "更新播放历史"), listMsgPushMgr("10041", "获取待发送消息列表"), addMsgPushMgr(
			"10042", "新增待发送消息"), addMsgPushHistory("10043", "新增消息发送历史"), listMsgPushHistoryMgr(
			"10044", "获取消息发送历史列表"), loginUser("10045", "用户登录"), refreshToken(
			"10046", "用户token刷新"), logoutUser("10047", "用户注销"), selectUserInfos(
			"10048", "用户后台筛选"), saveUserInfo("10049", "用户修改资料"), selectUserInfoById(
			"10050", "获取用户信息"), selectUserInfoByWord("10051", "好友搜索"), addFriend(
			"10052", "添加好友"), agreeFriend("10053", "同意好友"), deleteFriend(
			"10054", "拉黑好友"), selectFriendWhoIsFriend("10055", "获取好友"), selectFriendWhoWaitAgree(
			"10056", "获取待同意好友"), selectBabyInfos("10057", "后台筛选baby信息"), saveBabyInfo(
			"10058", "保存baby资料消息"), selectBabyInfoById("10059", "根据id获取baby信息"), selectBabyInfoByIdAndUserId(
			"10060", "根据id和用户id获取baby信息"), selectBabyInfoByUserInfoId("10061",
			"根据用户id获取baby列表"), selectBigUser("10062", "筛选用户上传的通讯录"), uploadBigUser(
			"10063", " 上传用户通讯录"), selectCategorys("10064", "筛选后台分类"), selectAppCategorys(
			"10065", "筛选app分类模块"), selectCategoryById("10066", " 根据id获取分类"), saveCategory(
			"10067", " 保存分类信息"), selectCategoryByParentId("10068", "据父id获取子分类"), deleteCategoryById(
			"10069", "删除分类"), saveUserAndCategory("10070", "保存用户自定义分类"), selectMenus(
			"10071", "筛选所有菜单"), selectBusinessMenus("10072", "筛选分类型菜单"), selectMenuById(
			"10073", "根据id获取菜单信息"), saveMenu("10074", "菜单保存"), deleteMenuById(
			"10075", "根据id删除菜单"), saveMenuAndCategory("10076", "保存菜单与分类关系"), selectCategoryByMenuId(
			"10077", "根据菜单id获取分类"), uploadHeadImage("10078", "上传用户头像图片"), getOrderType(
			"10079", "获取商品类型"), selectTops("10080", "筛选所有榜单"), selectTopById(
			"10081", "根据id获取榜单信息"), saveTop("10082", "榜单保存"), deleteTopById(
			"10083", "根据id删除榜单"), getFreeTraffice("10084", "基于订单获取用户免流量开通详情"), getSumConsumption(
			"10085", "获取用户累计消费金额"), getGoodsByName("10086", "校验商品是否已存在"), updateStatus(
			"10087", "更改商品状态"), listOpenServiceOrderMgr("10088", "获取服务开通记录列表"), selectLogs(
			"10089", "筛选日志"), listRechargeOrderMgr("10090", "获取充值购买记录列表"), listAlbumOrderMgr(
			"10091", "后台-获取专辑购买记录列表"), selectTopAlbumsByTopId("10092",
			"获取榜单下更多的专辑"), selectRecommendTops("10093", "获取榜单下的随机推荐专辑"),
			saveAlbum("10094","保存专辑"),deleteAlbum("10095","删除专辑"),
			saveAudio("10096","保存音频"),deleteAudio("10097","删除音频"),
			uploadAlbumImage("10098","上传专辑封面"),uploadAudioFile("10099","上传音频文件"),
			app_getAlbumInfoById("10100","获取专辑详情"),app_getAlbumListByCondition("10101","根据搜索条件获取专辑列表"),
			app_getAlbumListByCategoryId("10102","首页(精品)根据分类id获取专辑列表"),app_searchAlbum("10103","专辑搜索"),
			app_getDetailsById("10104","获取专辑作者出版社等信息"),app_getAlbumListbyExpertIdAndType("10105","获取专辑相关推荐"),
			app_getAudioInfoById("10106","获取音频详情"),app_getAudioListByAlbumId("10107","根据专辑id获取已上架音频列表"),
			app_searchAudio("10108","根据条件搜索音频"),
			saveBanner("10109","保存banner"),getBannerList("10110","获取有效banner列表"), 
			addMsgModelMgr("10111","新增消息模版"), listMsgModelMgr("10112","获取消息模版列表"), deleteMsgModelMgr("10113","删除消息模版"), 
			updateStatusMgr("10114","更改消息模版状态"), editModelMgr("10115","修改消息模版"), getBalanceDetail("10116","获取变动明细详情"), 
			buyAlbum("10117","购买专辑"), openServiceByBalance("10118","使用余额开通服务"), askPay("10119","生成订单，签名并调用统一下单接口"), 
			unifiedOrder("10120","统一下单"),saveSmsTemplet("10121","保存短信模板信息"),deleteSmsTempletById("10122","删除短信模板"), 
			notify("10123","微信支付回调"), listOpinionMgr("10124","获取用户反馈列表"), getModelByIdMgr("10125","根据ID获取消息模版"), 
			getHistoryAlbumByUserId("10126","根据用户ID获取最近播放专辑列表"), addAuthor("10127","新增作家"), deleteAuthor("10128","删除作家记录"), 
			listAuthorMgr("10129","获取作家列表"), editAuthor("10130","修改作家信息"), getAuthorById("10031","根据ID获取作家信息"), 
			upAuthorFile("10032","上传作家相关文件/音频"), listPlatFormOrderMgr("10033","后台管理-平台卡订单列表");

	private String fnId; // 功能id 即Resource唯一id
	private String fnDesc; // 功能描述

	private YHFunction(String fnId, String fnDesc) {
		this.fnId = fnId;
		this.fnDesc = fnDesc;
	}

	public String getFnId() {
		return fnId;
	}

	public String fnDesc() {
		return fnDesc;
	}

}
