# FirstApi
Пробуем делать свою первую Spring программу

Техническое задание:
user-service - Сервис для хранения пользователей системы

необходимо
- создать структуру БД для хранения пользователя. Хранимые поля ФИО, login, роль пользователя, признак блокировки
- реализовать метод api для получения данных пользователя при авторизации по login

структура ответа

{
    "fio": "Иванов Иван Иванович",
    "login": "ivanovii",
    "role": {
        "name": "admin",
        "description": "Администратор"
    }
}

необходимо учесть что если пользователь заблокирован то авторизоваться он не может




client-service - Сервис для создания и хранения информации о клиенте

необходимо
- создать метод для создания клиента

{
    "fio": "Иванов Иван Иванович",
    "birthDay": "1999-10-11",
    "passport": {
        "serial": "5400",
        "number": "123 456"
    },
    "address": "адрес прожвания"
}
- создать структуру БД для хранения клиента с уникальным идентификатором
- создать метод для обновления и получения информации о клиенте





product-service - Сервис для хранения информации о продуктах клиента

необходимо
- создать в БД таблицу для хранения доступных продуктов
- создать методо api для выдачу клиенту продукта

{
    "clientID": "идентификтор клиента",
    "productID" "идентификатор продукта",
    "productName": "название продукта"
    "accountNumber": "номер счета"
}

- создать структуру БД для хранения информации о выданых продуктах клиенту
- создать метод api для получения информации о всех продуктах клиента




alert-service - Сервис клиентских предложений

необходимо
- создать структуру БД для хранения информации о клиентских предложениях. Структура БД clientID, text
- создать структуру БД для хранения информации по истории клиентских предложений. Хранить реакцию клиента по озвученому предложению(Отказался, Принял, Ознакомлен)
- реализовать методы api для работы с клиентскими предложениями(создать предложение, получить предложение, сохранить историю с реакцией)




api-service - Сервис для работы с UI

необходимо
- реализовать авторизацию
- сделать проксирование всех запросов с другими сервисами
