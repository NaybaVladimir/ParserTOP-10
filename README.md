# ParserTOP-10
__Java 10/0/12;__

__Apache Maven 3.8.2;__

__jsoup;__

__Spring-boot(web, cache, thymeleaf, Jpa(hibernate);__

__h2 db.__

---------------------------------------------------------------------------------------------------------------------------------------------

Запуск приложения производится с Класса Main, находящегося в пакете ParserTOP-10/src/main/java/org/example/kpParserTop. Метод main(String[]args)

---------------------------------------------------------------------------------------------------------------------------------------------

В Сервисе реализовано два эндпоинта:

1) Парсит html-разметку страниц КП(Топ-250), забирает необходимую информацию -> сохраняет в БД и возвращает результат работы в формате json.

2) Возвращает представление - таблицу из ТОП-10, отсортированню по рэйтингу. 

---------------------------------------------------------------------------------------------------------------------------------------------

Особенности:

-В представление встроен фильтр по дате(можно отобразить ТОП-10 на разные даты). Если на необходимую дату не производилось обращения к "1)" - эндпоинту, бэкэнд вернет пустой список.

-Сервис разворачивается при помощи встроенного в spring-boot-starter-web контейнера сервлетов - tomcat. По  адресу: localhost, порт: 8080. 

-Имеется кэширующий слой, который по умолчанию кэширует список всех полей БД и обновляется при обращении к rest т.е. при внесении изменений в БД.

-При каждом перезапуске сервиса БД сбрасывается

---------------------------------------------------------------------------------------------------------------------------------------------

Сценарии:

GET - http://localhost:8080/ - вернет предстваление с пустой таблицей и фильтром по дате;

GET - http://localhost:8080/pars/kp - вернет json списка  только что преобразованных объектов.

