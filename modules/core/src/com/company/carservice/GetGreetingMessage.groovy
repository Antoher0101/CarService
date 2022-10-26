package com.company.carservice

import groovy.text.SimpleTemplateEngine

static def plurals(n){
    def ageLastNumber = n % 10;
    def exclusion = (n % 100 >= 11) && (n % 100 <= 14);
    def old = "";

    if (ageLastNumber == 1)
        old = "год";
    else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
        old = "лет";
    else if(ageLastNumber >= 2 && ageLastNumber <= 4)
        old = "года";
    if (exclusion)
        old = "лет";
    return old;
}
binding.setVariable("year", plurals(getBinding().getVariable("age")))

def template = 'Поздравляем вас с днем рождения, уважаемый $name $lastName!\n' +
        'Желаем всего наилучшего в ваши $age $year!\n' +
        'С уважением, коллектив автосервиса \"$carServiceName\".'

def engine = new SimpleTemplateEngine()
def message = engine.createTemplate(template).make(getBinding().variables)

return message.toString()
