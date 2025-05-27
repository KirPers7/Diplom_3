# Diplom_3

## What was done
*     классы тестируемых страниц и форм
*     классы POJO
*     классы-клиенты с методами-эндпойнтами
*     класс с генератором данных
*     вспомогательные методы API
*     все требуемые тесты
*     отчет о прогоне всех созданных тестов
___
## Tools & libs
*     selenium-java 3.141.59
*     RestAssured 5.3.0
*     Allure
*     JUnit 4.13.2
*     gson 2.10.1
___
## Running tests
`mvn clean test -DbrowserName=chrome`
`mvn clean test -DbrowserName=yandexBrowser`
### Creating a report
`mvn allure:serve`