# Capstone_Real-time_Braille_Scanner
## 2022-2 중앙대학교 캡스톤디자인 프로젝트
--------------------------

## 0. 팀원 소개
* 노현진 (20183784) :  서버 구축, 이미지 분석 알고리즘 적용, 점자 -> 한글 구현
* 이강은 (20173318) :  STT/TTS 적용, 앱 디자인, 프로젝트 발표
* 정현규 (20186984) :  한글 점자간 변환 알고리즘 구현, 프론트엔드 구현, 한글 -> 점자 구현

-----------
## 1. 서비스 소개

> 실시간 점자 번역 서비스

한글과 점자 간의 번역을 실시간으로 수행하여 사용자로 하여금 한글과 점자를 비교하여 학습할 수 있게 돕는 어플리케이션 서비스입니다. 

<img src="image/splash.jpg" height="400"/>

### 1.1. 서비스 대상

* **시각장애인 활동지원사**

  전맹인 시각장애인에게 점자 교육을 제공하고자 하지만 점자에 대한 지식이 많지 않은 활동지원사, 가족 등 

* **저시력 시각장애인**

  사물의 유무 정도는 분간할 수 있지만 시력이 낮아 글자를 읽는 데에는 한계가 있어 점자를 배울 필요가 있는 저시력 시각장애인
  
* **실명 질환 환자**

  시력이 남아 있지만 백내장, 녹내장, 황반변성 등 시력을 점차 잃어가게 되는 질병에 걸린 진행형 시각장애인
  
  
  
### 1.2. 주요 기능

#### 1.2.1. 한글을 점자로 번역하는 기능

1. 사용자가 한글로 된 텍스트를 카메라로 비추면, 하단에 점자로 표시되어 번역 결과가 나타납니다.
2. 국립 국어원에서 지정한 형식에 맞추어 실제 용례와 동일하게 번역됩니다. 

<img src="image/photo1.jpg" height="400"/>

#### 1.2.2. 점자를 한글로 번역하는 기능

1. 사용자가 점자로 된 텍스트를 카메라로 비추면, 하단에 한글로 표시되어 번역 결과가 나타납니다.
2. 국립 국어원에서 지정한 형식에 맞추어 실제 용례와 동일하게 번역됩니다. 

<img src="image/photo3.jpg" height="400"/>

#### 1.2.3. 환경설정 기능

1. 음성의 출력 속도를 조절할 수 있습니다.
2. 표시되는 텍스트의 크기를 조절할 수 있습니다.

<img src="image/photo4.jpg" height="400"/>

-----------

## 2. 기술 스택

### 2.1. 데이터 학습

> 이미지 기반으로 점자 번역 데이터를 학습시킨 모델을 사용했습니다.

* Python 3.9

<img src="image/python.png" height="100"/>

  1. 토치를 이용해서 데이터를 학습시키는 데에 효과적인 언어인 python을 사용했습니다.

* Torch

<img src="image/torch1.png" height="100"/>

  1. 점자 인식 데이터들을 Torch를 통해 이미지 기반으로 학습시켜 모델을 구축했습니다.
  2. 현재 널리 사용중인 PyTorch의 근간이 되는 모델입니다.

### 2.2. 백엔드

* Python 3.9

<img src="image/python.png" height="100"/>

  1. 토치를 이용해서 데이터를 학습시키는 데에 효과적인 언어입니다. 
  2. Flask를 이용한 웹 서버 구축에 효과적입니다.

* Flask Library

<img src="image/flask.png" height="100"/>

  1. 이미지 내의 점자 인식 라이브러리를 앱에서 사용하기 위해 Flask를 사용하였습니다. 
  2. 코드가 비교적 단순하고 Restful API를 구축하는 데에 효과적입니다. 
  3. 다양한 웹 엔진과 호환성이 높습니다.

* ML Kit

<img src="image/mlkit.png" height="100"/>

  1. 한글을 촬영할 때 이를 인식하여 텍스트 형태로 전환하기 위해, 구글에서 제공하는 ML Kit의 com.google.mlkit:text-recognition-korean 라이브러리를 사용하였습니다.
  2. Android와의 호환성이 높기 때문에 앱 개발에 효과적입니다. 

### 2.3. 프론트엔드

* Kotlin

<img src="image/kotlin.png" height="100"/>

  1. 코틀린 언어를 이용해서 프론트엔드 개발을 진행하였습니다.
  2. JAVA보다 더 간결한 문장과 다양한 기능을 제공하는 언어입니다.
  3. 안드로이드 개발 환경에서 가장 널리 쓰이는 언어입니다.

* Camera X

<img src="image/camerax.png" height="100"/>

  1. 카메라 앱 개발을 쉽게 하기 위해 개발된 Jetpack 라이브러리입니다.
  2. 한글과 점자 간의 실시간 번역을 위한 input image로 사용됩니다.

* Google Text-To-Speech API

<img src="image/tts.png" height="100"/>

  1. 한글로 쓰여진 내용을 음성으로 출력해주는 안드로이드 엔진입니다.
  2. 추가로 STT 기능도 탑재하여 음성을 한글로 출력하는 기능도 구현되었습니다.

### 2.4. 배포

* AWS EC2

<img src="image/aws.png" height="100"/>

  1. 서버에서 자동적으로 트래픽을 관리하기 때문에 사용이 효과적입니다.
  2. 실무에서 가장 널리 쓰이는 클라우드 컴퓨팅 서비스입니다.
  3. 목적에 따라 다양한 서비스와 라이브러리를 제공합니다.

### 2.4. 프로젝트 관리

* Github

<img src="image/github.jpeg" height="100"/>

  1. Github 환경에서 작업물을 실시간으로 공유하며 작업하였습니다. 
  2. 코드 수정 내용을 효과적으로 파악할 수 있어, 유동적으로 작업할 수 있습니다. 

-----------

## 3. 데이터 수집 및 분석 과정
