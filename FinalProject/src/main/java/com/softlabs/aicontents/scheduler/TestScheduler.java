package com.softlabs.aicontents.scheduler;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
@Slf4j

public class TestScheduler {

    private int executionCount = 0;

    //테스트용 : 3초마다 실행( 나중에 매일 08시로 변경)
    @Scheduled(cron = "0 * * * * *") //1분 마다 실행
    //cron??
    //실제 배포 시, @Scheduled(cron="0 0 8 * * *")
    public void excuteWorkFlow() {

        LocalDateTime startTime = LocalDateTime.now();
        log.info(" AI 컨탠츠 자동 생성 파이프 라인 시작 {}", startTime);

        try {
            // 1단계: 트렌드 키워드 수집
            String keyword = simulateTrendCollection();
            if (keyword == null) {
                throw new RuntimeException("키워드 수집 실패");
            }
//            // 2-1단계 : 상품 URL 수집
//        String productURL =simulateProductURL(keyword);
//        if(productURL==null){
//            throw new RuntimeException("상품 URL 수집 실패");
//        }
            // 2-2단계 : 상품 정보 수집
//             String productInfo =simulateProductInfo(productURL);
            String productInfo = simulateProductInfo(keyword);
            if (productInfo == null) {
                throw new RuntimeException("상품 정보 수집 실패");
            }
            //3단계 : LLM 컨탠츠 생성
            String content = simulateAiContent(productInfo);
            if (content == null) {
                throw new RuntimeException("컨탠츠 생성 실패");
            }
            //4단계 : 블로그 업로드(발행)
            String blogUpload = simulateBlogUpload(content);
            if (blogUpload == null) {
                throw new RuntimeException("블로그 업로드 실패");
            }

            //전체 성공
            LocalDateTime endTime = LocalDateTime.now();
            long duration = Duration.between(startTime, endTime).toMillis();
            //Duration??
            log.info("컨탠츠 자동 생성 완료! 소요시간: {}ms", duration);
            log.info("결과 - 키워드:{}, 블로그:{}", keyword, blogUpload);

        } catch (Exception e) {
            log.error("파이프 라인 실패: {}", e.getMessage());
//            handlePipeLineFailure(e);

        }
//        executionCount++;
//        log.info("Hello 스케줄러 실행! 횟수:{}, 시간: {}",
//                executionCount, LocalDateTime.now());
//
//        //향후 4단계 파이프라인 로직 추가 예정
//        log.info(" ->1단계: 키워드 수집 (준비중)");
//        log.info(" ->2단계: 상품 크롤링 (준비중)");
//        log.info(" ->3단계: 컨탠츠 생성 (준비중)");
//        log.info(" ->4단계: 블로그 업로드 (준비중)");
    }
//========메서드 선언

    //1단계 트랜드 키워드 수집 메서드
    private String simulateTrendCollection() {
        log.info(" 트랜트 키워드 50개 중 1개 랜덤 선택");

        //실제 트렌드 키워드 (더미 )
        String[] trendKeywords = {
                "에어컨", "선크림", "아이스크림", "선풍기", "냉장고",
                "휴대폰", "노트북", "헤드폰", "마우스", "키보드"
        };

        //시뮬레이션
        try {
            Thread.sleep(2500);
            //현재 쓰레드를 2.5초 일시정지
            //크롤링 사이트에 과도한 요청을 보내지 않기 위한 딜레이 목적
            //너무 빠른 요청 시, IP차단당할 수 있어서.
        } catch (InterruptedException e) {
            // 현재 스레드가 sleep 중에, 다른 스레드에 의해 강제로 깨워지는 예외가 발생하면,
            return null;
            //메소드를 즉시 종료하고 null값을 반환
        }
        String selectedKeywords = trendKeywords[new Random().nextInt(trendKeywords.length)];
        //trendKeywords 배열에서, 랜덤한 인덱스를 생성하여, 하나의 키워드 선택
        //new Random().nextInt(길이) : 0~길이-1까지의 랜덤 정수 생성
        //배열 [인덱스]로 해당 위치의 키워드를 가져와 selectedKeywords변수에 저장
        log.info("선택된 트렌드 키워드 : {}", selectedKeywords);
        return selectedKeywords;
        //선택된 키워드 반환
        //이 키워드가 상품 검색용 키워드로 사용
    }

    //2-1단계 싸다구몰에서 검색 후 상품의 URL수집
    //private String simulateProductURL(String keyword){
//        log.info("싸다구몰에서 '{}'로 상품 검색중",keyword);
//
//        String URL
//
//        try{Thread.sleep(5000);}catch (InterruptedException e){
//            return null;
//        }

    private String simulateProductInfo(String keyword) {
        log.info("싸다구몰에서 '{}'로 상품 검색중", keyword);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            return null;
        }
        //싸다구몰 상품 형태 시물레이션
        String productInfo = String.format(
                "상품명: %s / 관련 베스트 상품 , "
                        + "URL: https://ssadagu.kr/product/%d, 가격: %,d원",
                keyword,
                new Random().nextInt(9999) + 1000,
                (new Random().nextInt(50) + 10) * 1000
        );

        log.info(" 수집된 상품 :{}", productInfo);
        return productInfo;
    }

    //3단계 LLM 컨탠츠 생성 메서드

    private String simulateAiContent(String productInfo) {
        log.info("  AI API로  콘텐츠 생성 중...");

        // 시뮬레이션: 10-15초 소요 (실제 LLM API 시간 반영)
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            return null;
        }

        // 테스트용 컨탠츠 포맷
        String content = String.format("""
                         === SEO 최적화 블로그 콘텐츠 ===
                                    제목: %s 추천! 2025년 베스트 상품 리뷰
                        
                                    안녕하세요! 오늘은 요즘 핫한 %s에 대해 알아보겠습니다.
                        
                                    [상품 정보]
                                    %s
                                    [구매 가이드]
                                    - 가성비: ⭐⭐⭐⭐⭐
                                    - 품질: ⭐⭐⭐⭐⭐ 
                                    - 배송: ⭐⭐⭐⭐⭐
                        
                                    지금 ssadagu.kr에서 특가 진행 중이니 놓치지 마세요!
                        
                                    #%s #추천 #리뷰 #ssadagu #특가
                        
                        
                        """,
                productInfo.split("관련")[0],
                productInfo.split("관련")[0],
                productInfo,
                productInfo.split("관련")[0]
        );
        log.info("생성된 컨텐츠 길이:{}자", content.length());
        return content;
    }

        //4단계 블로그 업로드(발행) 메서드
    private String simulateBlogUpload(String content){
        log.info("   블로그로 업로드 중...");

        // 시뮬레이션: 2-3초 소요
        try { Thread.sleep(2500); } catch (InterruptedException e) { return null; }

        // 실제 네이버 블로그 URL 형태 시뮬레이션
        String blogUrl = String.format(
                "https://blog.naver.com/test_account_%d/post_%d",
                new Random().nextInt(999) + 100,
                System.currentTimeMillis() % 100000
        );

        log.info("   ✅ 업로드 완료: {}", blogUrl);
        return blogUrl;
    }
    // 실무에서 중요한 예외처리
    private void handlePipeLineFailure(Exception e){
        log.error("파이프라인 실패 처리");
        log.error("    - 실패 시간 :{}",LocalDateTime.now());
        log.error("    - 오류 유형 :{}",e.getClass().getSimpleName());
        log.error("    - 오류 메세지 :{}", e.getClass());


    }
}
