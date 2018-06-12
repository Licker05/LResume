//package com.nowcoder;
//
//import com.nowcoder.dao.NewsDAO;
//import com.nowcoder.model.News;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
//public class GetInforTest {
//
//    @Autowired
//    NewsDAO newsDAO;
//
//    public static int getNum(int start, int end) {
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        return random.nextInt( (end - start + 1) + start);
//    }
//
//    public static String getIPProxy(){
//        StringBuffer sb = new StringBuffer();
//        sb.append(getNum(2,254));
//        sb.append(".");
//        sb.append(getNum(2,254));
//        sb.append(".");
//        sb.append(getNum(2,254));
//        sb.append(".");
//        sb.append(getNum(2,254));
//        return sb.toString();
//    }
//    @Test
//    public void initInfor(){
//        Random random = new Random();
//        String mainURL = "http://xsgl.fafu.edu.cn/WebSite/Employment/TempRecruitList.aspx";
//        try {
//            //请求第一页
//            Document doc = Jsoup.connect(mainURL)
//                    .header("Connection", "keep-alive")
//                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0")
////					.header("x-forwarded-for", "180.118.247.203")
//                    .get();
//            Document sdoc = null;
//            String __EVENTVALIDATION = null;
//            String __VIEWSTATE = null;
//            int pageSum = Integer.parseInt(doc.select("#lblPageCount").text());
//            Elements getOne = null;
//            Elements getTime = null;
//            Elements getAll = null;
//            Elements detilInformation = null;
//            Elements decspan = null;
//            Elements decp = null;
////			System.out.println(first.select("#lblPageCount").text());
//            for(int i=0; i<pageSum; i++) {
//                //获取__VIEWSTATE和__EVENTVALIDATION值
//                __EVENTVALIDATION = doc.select("#__EVENTVALIDATION").val();
//                __VIEWSTATE = doc.select("#__VIEWSTATE").val();
//
//                //获取标题和时间和地址
//                getAll = doc.select("#Content").select("tr");
//                String shrefURL = "http://xsgl.fafu.edu.cn/WebSite/Employment/";
//
//                for(int j=0; j<getAll.size(); j+=2) {
//                    System.out.print(getAll.get(j).select("a").text() + "      ");
//                    System.out.println(getAll.get(j).select("font").text());
//                    //请求二级页面
//                    String tempURL = shrefURL + getAll.get(j).select("a").attr("href");
//                    System.out.println(tempURL);
//                    sdoc = Jsoup.connect(tempURL).get();
//
//                    //获取二级页面公司标题
//                    System.out.println(sdoc.select("#UnitName").text());
//                    //获取二级页面公司简介
//                    System.out.print("公司简介      ");
//                    System.out.println(sdoc.select("#UnitRemark").text());
//                    //获取招聘时间
//                    System.out.print("招聘时间      ");
//                    System.out.println(sdoc.select("#BeginDate").text());
//                    //获取联系人
//                    System.out.print("联系人          ");
//                    System.out.println(sdoc.select("#LinkMan").text());
//                    //获取招聘场地
//                    System.out.print("招聘场地       ");
//                    System.out.println(sdoc.select("#RecruitAddress").text());
//
//                    //获取信息
//                    detilInformation = sdoc.select("#LinkJobDes");
////					System.out.println(detilInformation.html());
//                    decspan = detilInformation.select("span");
//                    decp = detilInformation.select("p");
//
//                    News news = new News();
//                    news.setCommentCount(0);
//                    Date date = new Date();
//                    date.setTime(date.getTime() + 1000*3600*5*i);
//                    news.setCreatedDate(date);
//                    news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
//                    news.setLikeCount(0);
//                    news.setUserId(i+1);
//                    news.setTitle(getAll.get(j).select("a").text() + "      ");
//                    news.setLink(getAll.get(j).select("font").text());
//                    newsDAO.addNews(news);
//
//                    for(Element p: decp) {
//                        System.out.println(p.text());
//                    }
//
//                    Thread.sleep((int)(Math.random()*3000));
//
//                }
//
//                //Post请求获取下一页
//                doc = Jsoup.connect("http://xsgl.fafu.edu.cn/WebSite/Employment/TempRecruitList.aspx")
//                        .data("__EVENTTARGET","lbnNextPage")
//                        .data("__VIEWSTATE",__VIEWSTATE)
//                        .data("__EVENTVALIDATION", __EVENTVALIDATION)
//                        .data("left$login$LoginType", "S")
//                        .post();
////				System.out.println(doc.html());
//
//                Thread.sleep((int)(Math.random()*10000));
//            }
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
