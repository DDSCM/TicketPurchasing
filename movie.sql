/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : movie

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-06-18 10:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cinema_table`
-- ----------------------------
DROP TABLE IF EXISTS `cinema_table`;
CREATE TABLE `cinema_table` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_address` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cinema_table
-- ----------------------------
INSERT INTO `cinema_table` VALUES ('1', '金山区龙皓路1088号万达广场四楼（蒙山北路）', '万达影城');
INSERT INTO `cinema_table` VALUES ('2', '松江区车墩镇南乐路456号4幢4层', '珠影沪亚国际影城');
INSERT INTO `cinema_table` VALUES ('3', '金山区海汇街500号11号楼401室', 'DFC影城金山店');
INSERT INTO `cinema_table` VALUES ('4', '奉贤区钦林北路31号', '柘林影剧院');

-- ----------------------------
-- Table structure for `film_table`
-- ----------------------------
DROP TABLE IF EXISTS `film_table`;
CREATE TABLE `film_table` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_act` varchar(255) DEFAULT NULL,
  `f_country` varchar(255) DEFAULT NULL,
  `f_des` varchar(255) DEFAULT NULL,
  `f_name` varchar(255) DEFAULT NULL,
  `f_price` double DEFAULT NULL,
  `f_state` int(11) DEFAULT NULL,
  `f_time` varchar(255) DEFAULT NULL,
  `f_type` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `f_last` int(11) DEFAULT NULL,
  `num` double DEFAULT NULL,
  `f_rank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of film_table
-- ----------------------------
INSERT INTO `film_table` VALUES ('1', '丹尼斯·奎德,凯瑟琳·普雷斯科特,刘宪华,乔什·加德,贝蒂 · 吉尔平,玛格·海根柏格', '美国', '小狗贝利延续使命，在主人伊森的嘱托下，通过不断的生命轮回， 执着守护伊森的孙女CJ，将伊森对孙女的爱与陪伴，当做最重要的 使命和意义，最终帮助CJ收获幸福，再次回到主人伊森身边。', '一条狗的使命2', '60', '1', '2019', '剧情', '\\static\\post\\1.jpg', '130', '1.68', '9.3');
INSERT INTO `film_table` VALUES ('2', '梅纳·玛索德,娜奥米·斯科特,威尔·史密斯,马尔万·肯扎里', '美国', '在充满异域风情的古代阿拉伯王国，善良的穷小子阿拉丁（莫纳·马苏德 饰）和勇敢的茉莉公主（娜奥米·斯科特 饰）浪漫邂逅，在可以满足主人三个愿望的神灯精灵帮助下，两人踏上了一...', '阿拉丁', '68.88', '1', '2019', '科幻', '\\static\\post\\2.jpg', '128', '3', '8.9');
INSERT INTO `film_table` VALUES ('3', '米莉·博比·布朗,凯尔·钱德勒,莎莉·霍金斯,托马斯·米德蒂奇,布莱德利·惠特福德,维拉·法梅加,章子怡', '美国', '随着《哥斯拉》和《金刚：骷髅岛》在全球范围内的成功，华纳兄弟影片公司和传奇影业联手开启了怪兽宇宙系列电影的新篇章—一部史诗级动作冒险巨制。在这部电影中，哥斯拉将和众多大家在流行文化中所熟知的怪兽展开较量。全新故事中，研究神秘动物学的机构“帝王组织”成员将勇敢直面巨型怪兽，其中强大的哥斯拉也将和魔斯拉、拉顿和它的死对头——三头王基多拉展开激烈对抗。当这些只存在于传说里的超级生物再度崛起时，它们将展开王者争霸，人类的命运岌岌可危……', '哥斯拉2：怪兽之王', '77.77', '1', '2019', '科幻', '\\static\\post\\3.jpg', '132', '10.5', '8.2');
INSERT INTO `film_table` VALUES ('4', '瑞安·雷诺兹,贾斯提斯·史密斯,凯瑟琳·纽顿,渡边谦,卡兰·索尼', '美国', '好莱坞真人电影《大侦探皮卡丘》讲述了蒂姆·古德曼（贾斯提斯·史密斯饰） 为寻找下落不明的父亲来到莱姆市，意外与父亲的前宝可梦搭档大侦探皮卡丘相遇，并惊讶地发现自己是唯一能听懂皮卡丘说话的人类，他们决定组队踏上揭开真相的刺激冒险之路。', '大侦探皮卡丘', '50', '1', '2019', '科幻', '\\static\\post\\4.jpg', '104', '300.4', '8.5');
INSERT INTO `film_table` VALUES ('5', '赞恩·阿尔·拉菲亚,约丹诺斯·希费罗', '法国', '法庭上，十二岁的男孩赞恩向法官状告他的亲生父母，原因是，他们给了他生命。是什么样的经历让一个孩子做出如此不可思议的举动？故事中，赞恩的父母在无力抚养和教育的状况下依然不停生育，作为家中的长子赞恩，弱小的肩膀承担了无数生活的重压。当妹妹被强行卖给商贩为妻时，赞恩愤怒离家，之后遇到一对没有合法身份的母子，相互扶持勉强生活。然而生活并没有眷顾赞恩，重重磨难迫使他做出了令人震惊的举动……', '何以为家', '48.88', '1', '2019', '剧情', '\\static\\post\\5.jpg', '117', '201.6', '9.0');
INSERT INTO `film_table` VALUES ('6', '希里黛玉,阿克夏耶·坎纳', '印度', '本片改编自震惊印度的“德里黑公交案”。艾莉亚在一次派对活动后遭到强暴，面对凿凿证据，四名罪犯却被法庭判为无罪。艾莉亚的继母，戴维琪伤心欲绝，在走投无路后愤然决定亲手为女儿寻求正义，一场高能高智商的复仇大戏拉开序幕。正义到不了的地方，还有母亲！', '一个母亲的复仇', '19.8', '1', '2019', '剧情', '\\static\\post\\6.jpg', '146', '5.8', '7.8');
INSERT INTO `film_table` VALUES ('7', '大原惠美,嘉数由美,柳乐优弥,广濑爱丽丝', '日本', '月球探测器在月亮上捕捉到了白影，大雄认为这道白影是月亮上的兔子，惹来了大家的耻笑，于是哆啦A 梦为了帮助大雄，利用道具“异说俱乐部徽章”，在月球背面制造了一个兔子王国。一天，神秘少年露卡转学而来，与大雄和伙伴们一同前往月亮上的月兔王国展开了一场别开生面的浪漫想象力之旅。', '大雄的月球探险记', '33.66', '0', '2019', '动画', '\\static\\post\\7.jpg', '111', '0', '0');
INSERT INTO `film_table` VALUES ('8', '索菲·特纳,詹姆斯·麦卡沃伊,迈克尔·法斯宾德,詹妮弗·劳伦斯', '美国', '影片剧情围绕X战警中最受欢迎成员之一的琴·葛蕾展开，讲述她逐渐转化为黑凤凰的故事。在一次危及生命的太空营救行动中，琴被神秘的宇宙力量击中，成为最强大的变种人。此后琴·葛蕾不仅要设法掌控日益增长、极不稳定的力量，更要与自己内心的恶魔抗争，她的失控让整个X战警大家庭分崩离析，也让整个星球陷入毁灭的威胁之中。', 'X战警：黑凤凰', '88.88', '2', '2019', '科幻', '\\static\\post\\8.jpg', '114', '0', '0');
INSERT INTO `film_table` VALUES ('9', '柊瑠美,入野自由,夏木真理,中村彰男,内藤刚志', '日本', '千寻和爸爸妈妈一同驱车前往新家，在郊外的小路上不慎进入了神秘的隧道——他们去到了另外一个诡异世界—一个中世纪的小镇。远处飘来食物的香味，爸爸妈妈大快朵颐，孰料之后变成了猪！这时小镇上渐渐来了许多样子古怪、半透明的人。千寻仓皇逃出，一个叫小白的人救了他，喂了她阻止身体消 失的药，并且告诉她怎样去找锅炉爷爷以及汤婆婆，而且必须获得一分工作才能不被魔法变成别的东西。千寻在小白的帮助下幸运地获得了一份在浴池打杂的工作', '千与千寻', '33.33', '2', '2016', '动画', '\\static\\post\\9.jpg', '110', '0', '0');
INSERT INTO `film_table` VALUES ('10', '蒂娜·德赛,约瑟夫·梅,特瑞萨·加拉赫,凯瑞·莎勒,约翰·海斯勒', '英国', '一辆来自澳洲的淘气小赛车艾斯，参加世界巡回比赛时路过了多多岛。从未离开过多多岛的小火车托马斯听到艾斯游历世界的见闻后，也决定展开自己第一次的全球大冒险！他和新的朋友——来自非洲肯尼亚的女性火车妮亚，一起越过沙漠、丛林还有危险的高山，横跨非洲、南美洲、中美洲、北美洲和亚洲等五大洲，体验前所未见的壮丽景色和异国风情，用友谊、智慧与勇气写下了属于自己成长冒险之旅。', '世界探险记', '44.66', '2', '2019', '动画', '\\static\\post\\10.jpg', '86', '0', '0');
INSERT INTO `film_table` VALUES ('11', '王千源,张译,姜武,黄志忠,张俊一,欧豪,张承', '中国', '1937年淞沪会战末期，国民革命军第88师524团留守上海四行仓库，与租界一河之隔，孤军奋战4昼夜，造就了罕见的被围观的战争；为壮声势，四百人对外号称八百人。 电影《八佰》由管虎导演，是亚洲首部全片使用IMAX摄影机拍摄的商业影片，将于2019年7月5日全国上映。', '八佰', '33.77', '2', '2019', '战争', '\\static\\post\\11.jpg', '109', '0', '0');
INSERT INTO `film_table` VALUES ('12', '佐藤康夫,小凑昭尚,蔡鸿文,梁文道,陆川', '中国', '《尺八·一声一世》是聿馨导演历时三年拍摄的音乐人文纪录电影，片中记录了中日美等地的尺八演奏家，制管师，学习者的生活，通过他们的尺八之路，映照出每个人对音乐，生活，生命及世界的认知与感悟。为大众展现了生活的另一种可能。 尺八，是源于中国的竹制吹管乐器，因管长一尺八寸得名，音色苍凉辽阔，曾兴于盛唐，南宋后在中国式微，而在日本传承至今。如今作为《火影忍者》《阴阳师》等影视动漫配乐逐渐被中国年轻人所知。', '尺八·一声一世', '55.66', '2', '2019', '其他', '\\static\\post\\12.jpg', '91', '0', '0');
INSERT INTO `film_table` VALUES ('13', '刘晨毅,魏歆惠,周金凤,赵倪僮,崔文化', '中国', '《花儿与歌声》是一部以留守儿童为主题创作的作品。故事以离家出走的五年级学生范大强遇到了盲妹妹心明，带她回到家乡、走进学校为背景，描写了留守儿童与乡村老师之间的真挚情感和动人故事，让读者一步步走进那些远离父母的乡村孩子的心田。', '花儿与歌声', '22.33', '2', '2019', '剧情', '\\static\\post\\13.jpg', '108', '0', '0');
INSERT INTO `film_table` VALUES ('14', '陈飞宇,何蓝逗,惠英红,周楚濋', '中国', '每个人的心里大概都藏着一个念念不忘的人。一个偶然被提及的名字，让女摄影师耿耿（何蓝逗 饰）内心掀起万千波澜，触动了回忆的开关，那个撩人心动的少年余淮（陈飞宇 饰）再度闯进她的思绪。 那是记忆里最好的时光，“学渣”耿耿和“学霸”余淮成了同桌，还结识了简单（王初伊 饰）、贝塔（周楚濋 饰）、徐延亮（陈帅 饰）。', '最好的我们', '30', '2', '2019', '爱情', '\\static\\post\\14.jpg', '110', '0', '0');
INSERT INTO `film_table` VALUES ('15', '小罗伯特·唐尼，乔什·布洛林，克里斯·埃文斯，克里斯·海姆斯沃斯', '美国', '银河系中的至尊霸主灭霸带着几个得力手下洗劫了全宇宙，只为了将所有的无限宝石镶嵌于金属手套上，这个手套可以将整个银河系毁灭于弹指间。为了拯救宇宙，托尼·斯塔克和史蒂夫·罗杰斯需要摒弃前嫌，重组复仇者联盟，并与蜘蛛侠、奇异博士、银河护卫队、黑豹以及瓦坎达人民的力量一同作战 。', '复仇者联盟3', '88.66', '0', '2018', '科幻', '\\static\\post\\15.jpg', '150', '502.4', '9.0');
INSERT INTO `film_table` VALUES ('16', '	杰森·莫玛，艾梅柏·希尔德，叶海亚·阿卜杜勒-迈丁，帕特里克·威尔森，妮可·基德曼，威廉·达福', '美国', '海王（杰森·莫玛 饰）是美国DC漫画旗下超级英雄，本名亚瑟·库瑞，是海底之国亚特兰蒂斯的皇后和美国海边一个灯塔看守人的私生子，拥有半人类、半亚特兰蒂斯人的血统，从小就展现出了远超常人的各项体能，以及能在水下自由活动与呼吸，并和海洋生物沟通等异于他人的能力，在前任亚特兰蒂斯国王死后，王位空缺，其母派人找到他，加冕其为亚特兰蒂斯国王、掌管七海，并被赋予了亚特兰蒂斯王权的象征，能操控大海力量，掀起风浪的三叉戟，后与超人、蝙蝠侠等人创立正义联盟，成为正义联盟七大创始人之一。', '海王', '77.5', '0', '2018', '科幻', '\\static\\post\\16.jpg', '137', '86.2', '8.0');
INSERT INTO `film_table` VALUES ('17', '朗贝尔·维尔森，Lambert Wilson\r\n朗贝尔·维尔森，Lambert Wilson\r\n朗贝尔·维尔森，Lambert Wilson\r\n', '法国', '本片讲述的是南极帝企鹅族群孕育新生命的故事：企鹅爸爸和企鹅妈妈从相遇到相爱之后生下企鹅蛋，再到它们把企鹅蛋放在肚皮与脚之间孵出企鹅宝宝，小企鹅的生命历程就这样开始了。在小企鹅没长大之前，严寒、冰川裂缝以及强壮的海燕都可能危及它们脆弱的生命，它们得要努力地长大才行。一旦它们长大了，父母就会离开小企鹅，让它们独自面对未知的海洋世界。凭借自然的直觉，追随着神秘的召唤，小企鹅们踏上未知的旅程，这是属于它们的鹅生传奇。帝企鹅就这样生存繁衍在这片神奇的南极大路上，生生不息…', '帝企鹅日记2：召唤', '40', '0', '2018', '剧情', '\\static\\post\\17.jpg', '85', '153', '8.5');
INSERT INTO `film_table` VALUES ('18', '	黛茜·雷德利、约翰·波耶加、哈里森·福特等', '美国', '绝地归来三十多年后，光明与黑暗再次在银河系展开对决。银河帝国残余力量组成了第一秩序，而曾经的反抗军则演变为抵抗力量，双方为了一份地图而展开大战。第一秩序的士兵费恩（约翰·波耶加 饰）拒绝屠杀无辜人民，逃离军队，在沙漠星球贾库与蕾伊（黛茜·雷德利 饰）相遇，他们意外救下了掌握重要情报的BB-8。而此时，原力的黑暗面已经变得无比强大，第一秩序也大举追捕他们。逃亡过程中，二人遇到已经老去的汉·索罗（哈里森·福特 饰），知道了当年的英雄传说，并勇敢地承担起自己的责任，掌控自己的命运，挑战黑暗力量。', '星球大战：原力觉醒', '40', '0', '2017', '科幻', '\\static\\post\\18.jpg', '100', '240.5', '8.7');
INSERT INTO `film_table` VALUES ('19', '薛景求，金南佶，金雪炫，吴达洙', '韩国', '该片根据同名小说改编，讲述患有阿兹海默症的连续杀人犯炳秀(薛耿求饰)金盆洗手，可村庄却再现连环杀人案，这让炳秀陷入混乱记忆之中。于此同时女儿(金雪炫饰)，神秘男子(金南佶饰)也身陷其中。', '杀人者的记忆法', '38', '0', '2017', '悬疑', '\\static\\post\\19.jpg', '118', '63.1', '8.0');
INSERT INTO `film_table` VALUES ('20', '	李敏镐、钟汉良、唐嫣等', '韩国', '李山（李敏镐 饰）和王博宥（钟汉良 饰）曾经同为国际刑警，后因任务失败被一同革职，当起了私人保镖。在一起看似普通的爆炸案中，两人与凯蒂（唐嫣 饰）、天柯（吴千语 饰）和宝宝（樊少皇 饰）组成的赏金三人组狭路相逢，一番冲突较量后，他们组成了专门缉捕罪犯的赏金天团，在经历了连番惊险的任务后，五人凭着各自的绝技，成功挫败了连环恐怖袭击，抓住了幕后操控的黑手......', '\r\n赏金猎人', '35', '0', '2017', '悬疑', '\\static\\post\\20.jpg', '105', '20', '7.6');
INSERT INTO `film_table` VALUES ('21', '	钟汉良、李政宰等', '韩国', '海归华人郭志华（钟汉良 饰）在韩国结识了正在首尔进行学术交流的心理医生杨曦（郎月婷 饰），便委托她为烧伤毁容的哥哥郭志达进行创后心理诊疗辅导。于此同时，首尔正在进行着一场激烈的中韩足球对抗赛，决战之际，中方的队长忽然得知，自己的未婚妻被神秘人绑架，想要救出未婚妻就必须赢得比赛。韩国警方接到报警后，特工组长姜承俊（李政宰 饰）迅速将嫌疑人目标锁定在一个面具人身上，一番斗智斗勇后，警方顺利救出了人质。本以为一切已经结束时，姜承俊却发现面具人的计划才刚刚开始', '惊天大逆转', '30', '0', '2016', '悬疑', '\\static\\post\\21.jpg', '110', '5', '7.9');
INSERT INTO `film_table` VALUES ('22', '	林依晨、姜武等', '韩国', '讲述了苗苗（林依晨 饰）一家本来有着平静的生活，谁知在平安夜，家族的温馨聚餐却成为最后的晚餐。整个家族惨遭灭门，只有少女苗苗一人幸存。当她寻找惨案真相时，却发现家族中的每个人都在极力隐藏一个巨大的秘密，父亲（姜武 饰）、母亲（惠英红 饰）、弟弟（陈晓 饰）之间的关系愈发扑朔迷离，而这一切都要从几个月前苗苗被神秘男子性侵的那个雨夜说起……', '神秘家族', '26', '0', '2016', '悬疑', '\\static\\post\\22.jpg', '93', '3', '8.3');
INSERT INTO `film_table` VALUES ('23', '李秉宪，金伦奭', '韩国', '改编自2007年出版的畅销同名小说，由小说家金薰创作完成。 电影由CJ E&M投资发行，曾执导《我的父亲》、《熔炉》、《奇怪的她》等电影作品的导演黄东赫执导，预计下半年开机拍摄。 李炳宪将饰演崔明吉（音），为了百姓的身家性命力主求和； 而金允石则要饰演金常轩（音），主张与朝鲜王朝的禁卫军进行斗争。', '\r\n南汉山城', '22', '0', '2016', '战争', '\\static\\post\\23.jpg', '139', '10.5', '8.3');
INSERT INTO `film_table` VALUES ('24', '林时完、高雅星、李莱、李熙俊等', '韩国', '朝战如火如荼的年代，小鲜肉兵哥守护一群战地孤儿，成立儿童合唱团，在炮火中传递歌声。', '想念哥哥', '30', '0', '2015', '战争', '\\static\\post\\24.jpg', '124', '42', '7.4');
INSERT INTO `film_table` VALUES ('25', '	吴亦凡、卢杉、韩庚、周元等', '中国', '年少的夏木（吴亦凡 饰）因亲眼目睹母亲自杀而变得自我封闭，直到16岁的舒雅望（卢杉 饰）出现，用温暖关怀渐渐融化夏木的心。雅望青梅竹马的恋人唐小天（韩庚 饰）高中毕业后进入军校，不料就在唐小天就读军校期间，曲蔚然（周元 饰）出现并摧毁了雅望的生活，也让夏木在绝望之下做出疯狂行径...夏木、雅望、唐小天，他们还能找回曾经的那个天堂吗？', '夏有乔木 雅望天堂', '33', '0', '2015', '爱情', '\\static\\post\\25.jpg', '93', '186', '8.5');
INSERT INTO `film_table` VALUES ('26', '邓超，罗志祥，张雨绮，林允', '中国', '本片讲述的是一位富豪爱上美人鱼后决定停止对环境的破坏并钟爱环保的故事。富豪轩（邓超 饰）的地产计划涉及填海工程，威胁靠海以为生的居民。背负族人命运的美人鱼珊（林允 饰）被派遣前往刺杀轩。二人在交手过程中互生情愫。轩最终因为爱上珊而停止填海工作，可是另一波邪恶势力却对人鱼虎视眈眈……', '美人鱼', '48', '0', '2015', '爱情', '\\static\\post\\26.jpg', '93', '375.2', '9.2');
INSERT INTO `film_table` VALUES ('27', '周迅', '中国', '神农架的原始丛林里，小金丝猴淘淘倍感落寞，因为新出生的妹妹夺走了本该属于他的关爱，于是淘淘离开家人，成为了流浪猴中的一员，却必须面对种种残酷的现实。可可西里的荒原上，母藏羚羊和丈夫们告别，成群结队赶往某个圣地，迎接新生命的到来。而另一边，仙鹤在长空中翱翔，带走一个又一个结束了生命之旅的灵魂，展开下一段充满未知的轮回……', '我们诞生在中国', '20', '0', '2014', '剧情', '\\static\\post\\27.jpg', '79', '801.64', '9.7');
INSERT INTO `film_table` VALUES ('28', '	李家福', '中国', '中南医院妇产科，形形色色的故事上演从没有停过，5万块钱能救一大两小三条人命，手里只有5千元的丈夫，借钱、贷款、抵押房产此时都行不通，“拯救小凤之女”变得不可能完成；李家福——“拆弹部队”首领，面对夏锦菊保住子宫的请求，露出艰难而犹豫的眼神。心脏两次停跳，换血2万毫升，相当于全身换血4次，他如何剪断“炸弹”上的红蓝线，她又能否在“鬼门关”前转身？', '生门', '28', '0', '2014', '剧情', '\\static\\post\\28.jpg', '106', '404.8', '9.5');
INSERT INTO `film_table` VALUES ('29', '	胡歌，景甜，夏梓桐，徐娇', '中国', '不务正业的流浪少年兰伯特意外听到了邪恶的大黑龙手下魔族准备攻占阿尔特里亚大陆的情况，为了保护家乡他与魔物周旋被困，却被游侠巴尔纳救下，加入到了游侠杰兰特、阿尔杰塔（景甜 配音）的队伍中。精灵一族中的法师首领卡拉秋（夏梓桐 配音）也带着公主内尔文与弓箭手随从莉亚（徐娇 配音）前来邀请人类国王参战，面对魔物的入侵，他们和游侠队伍以及人类骑士贝斯柯德（胡歌 配音）组成了对付大黑龙的联盟。众人历经困难来到了大黑龙的巢穴，兰伯特与莉亚日久生情，但是他们却不知道杰兰特和阿尔杰塔，以及贝斯柯德各自带着不为人知的秘密……', '龙之谷：破晓奇兵', '36', '0', '2014', '动画', '\\static\\post\\29.jpg', '90', '1', '8.7');
INSERT INTO `film_table` VALUES ('30', '张曼玉，王祖贤，刘德华', '中国', '南宋是一个人妖难分的时期，法海和尚（赵文卓 饰）到处收服妖精，也扰乱了在西湖底修炼的白青二蛇。青（张曼玉 饰）曾获白（王祖贤 饰）相救，二者便以姐妹相称。姐妹俩受惑佯装成人生活在民间，白更嫁于老实书生许仙，青也同时看上了许仙，便常常以媚态勾引许仙，无奈许仙只深爱白一个。', '\r\n青蛇', '20', '0', 'other', '科幻', '\\static\\post\\30.jpg', '101', '25', '8.5');
INSERT INTO `film_table` VALUES ('31', '	萨尔曼·汗，索娜姆·卡普尔，阿努潘·凯尔，尼尔·尼汀·穆科什', '印度', '《遇上我的真命天子》是一部宝莱坞制作的浪漫喜剧电影，由萨尔曼·汗和索娜姆·卡普尔主演，2015年11月12日在印度和巴基斯坦上映。本片是萨尔曼·汗和导演Sooraj R. Barjatya的第四次合作，并在商业上取得了巨大成功，全球票房达到5900万美元，仅次于《小萝莉的猴神大叔》、《巴霍巴利王：开端》列印度票房年度第三。', '\r\n遇上我的真命天子', '25', '0', 'other', '爱情', '\\static\\post\\31.jpg', '164', '34', '6.5');
INSERT INTO `film_table` VALUES ('32', '阿尔弗雷德·莫里纳,约翰·利特高,玛丽莎·托梅,夏安·杰克逊 等', '法国', '老年同志本（约翰·利特高 饰）和乔治（阿尔弗雷德·莫里纳 饰）相守近四十年。在纽约州同性婚姻合法后，他们终于可以在曼哈顿举行田园诗意般的婚礼、许下终生相伴的誓言。然而此举却让教会学校找到理由解聘了乔治。顿失经济来源的两人变得无法承担公寓租金，迫于无奈下惟有搬离多年爱巢，各自寄住于不同亲友的家中。', '爱很奇怪\r\n', '35', '0', 'other', '喜剧', '\\static\\post\\32.jpg', '94', '25', '7.8');
INSERT INTO `film_table` VALUES ('33', '梅丽莎·玛斯等', '法国', '莫扎特（米开朗琪罗·勒孔特 Mikelangelo Loconte 饰）自幼便展现出了过人的音乐天赋，长大后，他和同为音乐家的父亲一起为教皇工作。新上任的统治者是一个毫无情趣，性格异常古板的男人，这让向来自由不羁的莫扎特感到难以忍受。20岁那一年，莫扎特和母亲一起离开了故乡萨尔斯堡，前往欧洲另谋生路。', '摇滚莫扎特', '30', '0', 'other', '喜剧', '\\static\\post\\33.jpg', '130', '153.78', '7.9');
INSERT INTO `film_table` VALUES ('34', '吉恩.凯利，莱斯利·卡伦', '英国', '浪漫之都巴黎，成为战后艺术、友谊和爱情故事的背景，一位美国士兵与美丽而年轻的舞者在这里相遇……格什温兄弟的《一个美国人在巴黎》是一段浪漫的巴黎旅行中诞生的交响诗，亦曾是经典奥斯卡获奖歌舞片，音乐剧版由英国皇家歌剧院著名编舞克里斯多夫·威尔顿操刀，纽约城市芭蕾舞团前首席罗伯特·费尔柴尔德和利安娜·考普领衔，带来无与伦比的视听盛宴， 狂揽托尼奖与奥利弗奖的同时，破纪录获得28家英国主流媒体五星好评！', '一个美国人在巴黎', '33', '0', 'other', '喜剧', '\\static\\post\\34.jpg', '122', '12', '8.6');
INSERT INTO `film_table` VALUES ('35', '萨姆·沃辛顿，佐伊·索尔达娜等', '英国', '战斗中负伤而下身瘫痪的前海军战士杰克·萨利（萨姆·沃辛顿 饰）决定替死去的同胞哥哥来到潘多拉星操纵格蕾丝博士（西格妮·韦弗 饰）用人类基因与当地纳美部族基因结合创造出的 “阿凡达” 混血生物。杰克的目的是打入纳美部落，外交说服他们自愿离开世代居住的家园，从而SecFor公司可砍伐殆尽该地区的原始森林，开采地下昂贵的“不可得”矿。', '\r\n阿凡达', '40', '0', 'other', '科幻', '\\static\\post\\35.jpg', '123', '730.5', '9.4');
INSERT INTO `film_table` VALUES ('36', '安吉丽娜·朱莉、艾丽·范宁', '英国', '玛琳菲森（安吉丽娜·朱莉 饰）曾是一个美丽纯洁，拥有翅膀能够飞翔的年轻仙子，生长于宁静祥和的森林王国。然而美好的时光总是短暂的，王国突遭人类军队侵袭，玛琳菲森在战斗中逐渐成长为这片森林的守护者，同时也遭受到了无情背叛，从此她的心灵开始变得冷酷，脑海只剩复仇的念头。为了报复，她给人类国王的女儿爱洛公主施下恶咒；然而随着爱洛的成长，玛琳菲森才逐渐意识到——这位小公主不仅能给两个世界带来和平，也许还能给自己带来真正的快乐。', '沉睡魔咒', '46', '0', '2015', '科幻', '\\static\\post\\36.jpg', '97', '42.5', '8.2');
INSERT INTO `film_table` VALUES ('37', '大森贵弘、伊藤秀樹', '日本', '夏目（神谷浩史 配音）在一次归还妖怪名字的过程中，结识了外祖母玲子（小林沙苗 配音）的旧识津村容莉枝岛本须美 配音）和她的儿子椋雄（高良健吾 配音）。在与其接触后，夏目的“保镖”猫咪老师（井上和彦 配音）竟第一次意外分裂成了三只！夏目能否解决危机？这对母子又与妖怪有何关系？', '\r\n夏目友人帐', '30', '0', '2016', '动画', '\\static\\post\\37.jpg', '100', '91.7', '8.7');
INSERT INTO `film_table` VALUES ('38', '西里斯', '英国', '歌剧魅影', '歌剧魅影', '50', '0', 'other', '剧情', '\\static\\post\\38.jpg', '111', '2', '8.9');
INSERT INTO `film_table` VALUES ('39', '马里奥·毛瑞尔、平采娜·乐维瑟派布恩', '泰国', '初中生小水（平采娜·乐维瑟派布恩 饰）相貌平平，家境一般，所以在学校里并不受重视。但是她心地善良，又有一群死党，日子过得倒也开心。某天，她遇见了帅气的学长阿亮（马里奥·毛瑞尔 饰），春心萌动，无 法遏制。她喜欢看他踢足球，看他拍照，如痴如狂。上英语课时，她不停地给死党传纸条 表达对阿亮的爱慕。然而，英语老师则指出她除了英语一无是处。', '\r\n初恋这件小事', '50', '1', '2017', '喜剧', '\\static\\post\\39.jpg', '118', '1', '7.5');
INSERT INTO `film_table` VALUES ('40', '	德·辰塔维西、努娜能提妲莎彭', '泰国', '泰国男生dak（辰塔维·塔纳西维 饰）因拒绝与女友结婚而被抛弃。喝得烂醉后隔天独自踏上原先和女友预订的韩国旅程。宿醉语言又不通的dak只能向，只能向同一旅行团中的一名泰国女生may求助（努娜能提妲莎彭 饰）。may有一位大男子主义，对她管得彻头彻尾的男友金哥，这一次是背着男友偷跑来韩国参加好友的婚礼。因为漏接金哥的电影导致两个大吵一顿最后分手。', '你好，陌生人', '45', '1', '2018', '喜剧', '\\static\\post\\40.jpg', '130', '50.2', '7.4');
INSERT INTO `film_table` VALUES ('41', '	阿尤斯曼·库拉纳、塔布', '印度', '该片讲述了满怀抱负的钢琴调音师阿卡什（Akash），为了获取音乐灵感一直假装盲人，在被邀请参加一场私人音乐会时却意外“目睹”一起凶杀案，成为现场唯一“目击证人”。', '\r\n调音师', '30', '1', '2019', '喜剧', '\\static\\post\\41.jpg', '137', '100.96', '9.0');
INSERT INTO `film_table` VALUES ('42', '	菅田将晖 、 土屋太凤 、 古川雄辉 、 山田裕贵 、 池田依来沙 、 滨边美波 、 佐野岳 、 佐野史郎 、 速水直道', '日本', '讲述了没有朋友，只懂闷头学习的高冷女学霸水谷雫（土屋太凤饰演），与举止怪异、没人敢亲近的“怪”同学吉田春（菅田将晖饰演）相识后，逐渐体会到友情和爱情滋味的青春故事。', '邻座的怪同学', '20', '1', '2019', '喜剧', '\\static\\post\\42.jpg', '102', '132', '8.5');
INSERT INTO `film_table` VALUES ('43', '王宝强  [1]，刘昊然 ，潘粤明，张子枫，妻夫木聪', '中国', '在《唐探2》结局的部分，唐仁和野田昊都接到一个来自日本的电话，大呼案子太难，提前透露了第三部的故事地点——东京。陈思诚透露，《唐探3》已被列入拍摄计划，未来将在2020年大年初一和观众见面。', '\r\n唐人街探案3', '40', '2', '2019', '动作', '\\static\\post\\43.jpg', '138', '0', '0');
INSERT INTO `film_table` VALUES ('44', '刘德华，古天乐，苗侨伟，林嘉欣', '中国', '该片以“毒品”为线索，讲述了慈善家兼金融巨子余顺天与“香港最大毒贩”地藏之间由“禁毒”引发的一场天地对决。', '扫毒2天地对决', '33', '2', '2019', '犯罪', '\\static\\post\\44.jpg', '117', '0', '0');
INSERT INTO `film_table` VALUES ('45', '古天乐、林峯、郑嘉颖、夏嫣、周秀娜', '中国', '廉政公署收到报案人廖雨萍（周秀娜 饰）的实名举报，举报正在坐牢的富二代曹元元（林峯 饰）涉嫌行贿监狱里的监督沈济全（谭耀文 饰）以及惩教员，首席调查主任陆志廉（古天乐 饰）决定深入虎穴，卧底狱中。在监狱里，被陆志廉送入监狱的前警司黄文彬（林家栋 饰）以及曹元元两大帮派势成水火，陆志廉趁机接近曹元元取得信任。同时监狱外的廉政公署总调查主任程德明（郑嘉颖 饰）、国内反贪局行动处处长洪亮（丁海峰 饰）也陆港联手，通力合作，最终成功破获贪腐行贿大案。', '\r\n反贪风暴4', '44', '1', '2019', '动作', '\\static\\post\\45.jpg', '107', '205.7', '9.0');
INSERT INTO `film_table` VALUES ('46', '	阿努克·斯特芬，伊莎贝尔·奥特曼，莉莲·奈福，布鲁诺·甘茨，克里斯托夫·高格勒，安娜·申斯', '法国', '海蒂（阿努克·斯戴芬 饰）很小就失去了父母，无依无靠伶仃飘零，所幸得到了姨妈（安娜·申茨 饰）的收留，然而，这照顾却不能够持久，最终，海蒂来到了阿尔卑斯山，投奔住在那里的爷爷（布鲁诺·甘茨 饰）。在村民们眼中，爷爷是个倔强而又古怪的老头，对其敬而远之，然而海蒂那双天真无邪的眼睛发现了爷爷深藏在内心的柔情，一老一少两人卸下心防，相依为命。 一个名为皮特（昆林·艾格匹 饰）放羊男孩成为了海蒂的新朋友，两人之间结下的深厚的友谊。', '海蒂和爷爷', '33', '1', '2019', '剧情', '\\static\\post\\46.jpg', '11', '42.5', '8.2');
INSERT INTO `film_table` VALUES ('47', '王明泉', '法规及', '测试用例', '垃圾狗', '1', '2', null, '什么', '\\static\\post\\20190609160344506.jpg', '125', '0', null);

-- ----------------------------
-- Table structure for `hall_table`
-- ----------------------------
DROP TABLE IF EXISTS `hall_table`;
CREATE TABLE `hall_table` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `col_num` int(11) DEFAULT NULL,
  `row_num` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `hh_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`h_id`),
  KEY `FKdo63erfo1c4cd92smtnex3juw` (`c_id`),
  CONSTRAINT `FKdo63erfo1c4cd92smtnex3juw` FOREIGN KEY (`c_id`) REFERENCES `cinema_table` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hall_table
-- ----------------------------
INSERT INTO `hall_table` VALUES ('1', null, null, '1', '1');
INSERT INTO `hall_table` VALUES ('2', null, null, '1', '2');
INSERT INTO `hall_table` VALUES ('3', null, null, '1', '3');
INSERT INTO `hall_table` VALUES ('4', null, null, '1', '4');
INSERT INTO `hall_table` VALUES ('5', null, null, '2', '1');
INSERT INTO `hall_table` VALUES ('6', null, null, '2', '2');
INSERT INTO `hall_table` VALUES ('7', null, null, '2', '3');
INSERT INTO `hall_table` VALUES ('8', null, null, '2', '4');
INSERT INTO `hall_table` VALUES ('9', null, null, '2', '5');
INSERT INTO `hall_table` VALUES ('10', null, null, '3', '1');
INSERT INTO `hall_table` VALUES ('11', null, null, '3', '2');
INSERT INTO `hall_table` VALUES ('12', null, null, '3', '3');
INSERT INTO `hall_table` VALUES ('13', null, null, '3', '4');
INSERT INTO `hall_table` VALUES ('14', null, null, '4', '1');
INSERT INTO `hall_table` VALUES ('15', null, null, '4', '2');
INSERT INTO `hall_table` VALUES ('16', null, null, '4', '3');
INSERT INTO `hall_table` VALUES ('17', null, null, '4', '4');
INSERT INTO `hall_table` VALUES ('18', null, null, '4', '5');

-- ----------------------------
-- Table structure for `manager_table`
-- ----------------------------
DROP TABLE IF EXISTS `manager_table`;
CREATE TABLE `manager_table` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(255) DEFAULT NULL,
  `m_phone` varchar(255) DEFAULT NULL,
  `m_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of manager_table
-- ----------------------------
INSERT INTO `manager_table` VALUES ('1', '王明泉', '13262267693', '160120312');
INSERT INTO `manager_table` VALUES ('2', 'cc', '15800736358', 'cc');
INSERT INTO `manager_table` VALUES ('3', 'wmq', '14329586315', 'a4g2#');
INSERT INTO `manager_table` VALUES ('4', 'ww', '16854328765', 'sv.6');

-- ----------------------------
-- Table structure for `order_table`
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `sf_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`o_id`),
  KEY `FK628tqw04ya4ym3s21sn3tlpog` (`sf_id`),
  KEY `FK66gffmjb214jw8gl7m2dnxcva` (`u_id`),
  CONSTRAINT `FK628tqw04ya4ym3s21sn3tlpog` FOREIGN KEY (`sf_id`) REFERENCES `show_film_table` (`sf_id`),
  CONSTRAINT `FK66gffmjb214jw8gl7m2dnxcva` FOREIGN KEY (`u_id`) REFERENCES `user_table` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_table
-- ----------------------------
INSERT INTO `order_table` VALUES ('50', '60', '23', '88', '7');

-- ----------------------------
-- Table structure for `show_film_table`
-- ----------------------------
DROP TABLE IF EXISTS `show_film_table`;
CREATE TABLE `show_film_table` (
  `sf_id` int(11) NOT NULL AUTO_INCREMENT,
  `show_hour` varchar(255) DEFAULT NULL,
  `show_time` date DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `f_id` int(11) DEFAULT NULL,
  `hh_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sf_id`),
  KEY `FKdl48cfr2l4gn0c0mqqs09v7g0` (`c_id`),
  KEY `FKo2akiqvcqacm37d3ibuo276jp` (`f_id`),
  CONSTRAINT `FKdl48cfr2l4gn0c0mqqs09v7g0` FOREIGN KEY (`c_id`) REFERENCES `cinema_table` (`c_id`),
  CONSTRAINT `FKo2akiqvcqacm37d3ibuo276jp` FOREIGN KEY (`f_id`) REFERENCES `film_table` (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of show_film_table
-- ----------------------------
INSERT INTO `show_film_table` VALUES ('1', '12:00', '2019-05-29', '1', '5', '1');
INSERT INTO `show_film_table` VALUES ('2', '12:00', '2019-06-01', '1', '2', '1');
INSERT INTO `show_film_table` VALUES ('3', '13:00', '2019-06-02', '1', '3', '3');
INSERT INTO `show_film_table` VALUES ('4', '14:30', '2019-05-31', '1', '4', '4');
INSERT INTO `show_film_table` VALUES ('5', '18:10', '2019-05-30', '1', '1', '4');
INSERT INTO `show_film_table` VALUES ('6', '09:00', '2019-05-29', '1', '6', '3');
INSERT INTO `show_film_table` VALUES ('7', '15:20', '2019-05-29', '1', '39', '1');
INSERT INTO `show_film_table` VALUES ('8', '06:51', '2019-06-01', '1', '40', '2');
INSERT INTO `show_film_table` VALUES ('9', '16:30', '2019-06-01', '1', '41', '1');
INSERT INTO `show_film_table` VALUES ('10', '13:20', '2019-05-24', '1', '42', '1');
INSERT INTO `show_film_table` VALUES ('11', '17:50', '2019-05-24', '1', '45', '3');
INSERT INTO `show_film_table` VALUES ('12', '13:40', '2019-05-24', '1', '46', '2');
INSERT INTO `show_film_table` VALUES ('13', '12:00', '2019-05-30', '1', '1', '1');
INSERT INTO `show_film_table` VALUES ('87', '15:20', '2019-05-30', '1', '1', '3');
INSERT INTO `show_film_table` VALUES ('88', '09:10', '2019-05-30', '1', '1', '4');
INSERT INTO `show_film_table` VALUES ('89', '16:10', '2019-05-31', '1', '1', '4');
INSERT INTO `show_film_table` VALUES ('90', '16:50', '2019-05-31', '1', '1', '2');
INSERT INTO `show_film_table` VALUES ('91', '14:30', '2019-06-01', '1', '1', '3');
INSERT INTO `show_film_table` VALUES ('92', '16:20', '2019-06-01', '1', '1', '1');
INSERT INTO `show_film_table` VALUES ('93', '09:00', '2019-06-02', '1', '1', '2');
INSERT INTO `show_film_table` VALUES ('94', '13:40', '2019-05-23', '2', '5', '5');
INSERT INTO `show_film_table` VALUES ('95', '12:00', '2019-05-25', '2', '2', '4');
INSERT INTO `show_film_table` VALUES ('96', '15:20', '2019-05-25', '2', '3', '1');
INSERT INTO `show_film_table` VALUES ('97', '09:10', '2019-06-11', '2', '4', '2');
INSERT INTO `show_film_table` VALUES ('98', '16:10', '2019-06-02', '2', '1', '3');
INSERT INTO `show_film_table` VALUES ('99', '16:50', '2019-06-05', '2', '6', '5');
INSERT INTO `show_film_table` VALUES ('100', '14:30', '2019-05-27', '2', '39', '3');
INSERT INTO `show_film_table` VALUES ('101', '16:20', '2019-06-12', '2', '40', '1');
INSERT INTO `show_film_table` VALUES ('102', '09:00', '2019-06-17', '2', '41', '2');
INSERT INTO `show_film_table` VALUES ('103', '12:00', '2019-05-21', '2', '42', '4');
INSERT INTO `show_film_table` VALUES ('104', '13:00', '2019-05-17', '3', '5', '4');
INSERT INTO `show_film_table` VALUES ('105', '14:30', '2019-05-17', '3', '2', '3');
INSERT INTO `show_film_table` VALUES ('106', '18:10', '2019-06-19', '3', '3', '1');
INSERT INTO `show_film_table` VALUES ('107', '09:00', '2019-06-19', '3', '4', '2');
INSERT INTO `show_film_table` VALUES ('108', '15:20', '2019-05-25', '3', '1', '4');
INSERT INTO `show_film_table` VALUES ('109', '06:51', '2019-06-11', '3', '6', '3');
INSERT INTO `show_film_table` VALUES ('110', '16:30', '2019-06-02', '3', '39', '2');
INSERT INTO `show_film_table` VALUES ('111', '16:10', '2019-06-05', '3', '40', '4');
INSERT INTO `show_film_table` VALUES ('112', '16:50', '2019-05-27', '3', '41', '1');
INSERT INTO `show_film_table` VALUES ('113', '14:30', '2019-06-12', '3', '42', '2');
INSERT INTO `show_film_table` VALUES ('114', '16:20', '2019-05-25', '3', '45', '3');
INSERT INTO `show_film_table` VALUES ('115', '09:00', '2019-06-11', '3', '46', '4');
INSERT INTO `show_film_table` VALUES ('116', '12:00', '2019-06-02', '4', '5', '5');
INSERT INTO `show_film_table` VALUES ('117', '13:00', '2019-06-05', '4', '2', '3');
INSERT INTO `show_film_table` VALUES ('118', '12:00', '2019-05-27', '4', '3', '1');
INSERT INTO `show_film_table` VALUES ('119', '15:20', '2019-05-27', '4', '4', '2');
INSERT INTO `show_film_table` VALUES ('120', '09:10', '2019-06-12', '4', '1', '4');
INSERT INTO `show_film_table` VALUES ('121', '16:10', '2019-05-25', '4', '6', '2');
INSERT INTO `show_film_table` VALUES ('122', '16:50', '2019-06-05', '4', '39', '3');
INSERT INTO `show_film_table` VALUES ('123', '14:30', '2019-05-27', '4', '40', '1');
INSERT INTO `show_film_table` VALUES ('124', '16:20', '2019-06-12', '4', '41', '5');
INSERT INTO `show_film_table` VALUES ('126', '16:16', '2019-05-31', '1', '1', '1');

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) DEFAULT NULL,
  `u_phone` varchar(255) DEFAULT NULL,
  `u_pwd` varchar(255) DEFAULT NULL,
  `u_sex` varchar(255) DEFAULT NULL,
  `potrait` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', '王', '13262267693', '123456', 'm', '\\static\\portrait\\init.jpg');
INSERT INTO `user_table` VALUES ('3', '1601', '13262549873', '1Vadz$', 'f', '\\static\\portrait\\init.jpg');
INSERT INTO `user_table` VALUES ('4', '1614', '13487951284', 'dj#ak.f', 'f', '\\static\\portrait\\init.jpg');
INSERT INTO `user_table` VALUES ('6', 'w', '13262267693', '123', null, '\\static\\portrait\\init.jpg');
INSERT INTO `user_table` VALUES ('7', '222', '12345678901', '123', null, '\\static\\portrait\\init.jpg');

-- ----------------------------
-- Table structure for `view_table`
-- ----------------------------
DROP TABLE IF EXISTS `view_table`;
CREATE TABLE `view_table` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_context` varchar(255) DEFAULT NULL,
  `v_score` int(11) DEFAULT NULL,
  `f_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`v_id`),
  KEY `FKq15re7jggtmb3ejiqmq0xkp11` (`f_id`),
  KEY `FK96jtvbwpivrro6s6bwlejsbea` (`u_id`),
  CONSTRAINT `FK96jtvbwpivrro6s6bwlejsbea` FOREIGN KEY (`u_id`) REFERENCES `user_table` (`u_id`),
  CONSTRAINT `FKq15re7jggtmb3ejiqmq0xkp11` FOREIGN KEY (`f_id`) REFERENCES `film_table` (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of view_table
-- ----------------------------
INSERT INTO `view_table` VALUES ('1', '很棒！', '5', '1', '1');
