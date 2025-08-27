# Final-7team

# 프로젝트 초기 구조 및 빌드 환경 설정

## 📋 개요
Spring Boot 프로젝트의 기본 구조와 빌드 환경을 설정합니다.

## 🛠️ 기술 스택
- **Java**: 21
- **Spring Boot**: 3.5.5
- **빌드 도구**: Gradle (Groovy DSL)

## 📁 프로젝트 구조
```
FinalProject/
├── build.gradle                    # Gradle 빌드 설정 (Groovy DSL)
├── settings.gradle                 # 프로젝트 설정
├── gradlew, gradlew.bat            # Gradle Wrapper
├── gradle/wrapper/                 # Gradle Wrapper 파일
├── .gitignore, .gitattributes      # Git 설정
└── src/main/java/com/softlabs/aicontents/
    ├── application/                # 스프링 부트 진입점
    ├── common/                     # 공통 유틸리티 코드 
    ├── config/                     # 전역/공통 설정 파일
    ├── domain/                     # 도메인(기능별) 분리
    ├── log/                        # 로그 관리
    ├── orchestration/              # 오케스트레이션
    └── scheduler/                  # 스케줄러
```

## 🔧 빌드 환경 구성

- Gradle Groovy DSL

## 📡 접속 확인
- **URL**: `http://localhost:8080`
- **포트**: 8080 (기본값)
- **상태 확인**: `http://localhost:8080/actuator/health`
