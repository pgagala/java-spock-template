package com.github.pgagala

import spock.lang.Specification

class CalculatorServiceSpec extends Specification {

    private CalculatorService calculatorService = new CalculatorService()

    def "Sum should be added"() {
        when:
        def result = calculatorService.add(first, second)

        then:
        result == expectedResult

        where:
        first               | second               | expectedResult
        1                   | 2                    | 3
        0                   | 0                    | 0
        5                   | 3                    | 8
        4.0                 | 3.3                  | 7.3
        new BigDecimal(4.5) | new BigDecimal(4.67) | new BigDecimal(9.17)
    }

    def "For invalid arguments exception should be thrown"() {
        when:
        calculatorService.add(first, second)

        then:
        def exc = thrown(IllegalArgumentException)
        exc != null

        where:
        first | second
        null  | 2
        0     | null
        null  | null
        2     | new BigDecimal(2)
    }

}
