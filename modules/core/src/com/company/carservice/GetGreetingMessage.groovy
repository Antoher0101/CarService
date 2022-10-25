package com.company.carservice

import groovy.text.SimpleTemplateEngine

def template = 'Поздравляем вас с днем рождения, уважаемый $name $lastName!\n' +
        'Желаем всего наилучшего в ваши $age лет!\n' +
        'С уважением, коллектив автосервиса \"$carServiceName\".'

def engine = new SimpleTemplateEngine()
def message = engine.createTemplate(template).make(getBinding().variables)

return message.toString()
