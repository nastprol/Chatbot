# ChatBot

This Chatbot is Telegrambot that is able to play Battleship game

реализации не должны зависеть от других реализаций, а должны зависеть от абстракций Game Map фабрика для игр git

Дублирование(Tuple и POint) game parser и отделить логику

Формулировка задачи: Хранить все состояние игры только в базе данных. Игру можно начать на одном, а продолжить на другом экземпляре чат-бота. Для каждого пользователя хранится свое состояние игры Несколько пользователей смогут играть одновременно

Привязать бота к Телеграмму

Чем это научит: использовать паттерн Singleton для доступа к базе данных(не боьше одного подключения к базе данных вне зависимости от числа пользователей), работа с SQL
