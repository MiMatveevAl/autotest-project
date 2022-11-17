@all
@test
Feature: feature_1

  Scenario: scenario_1
    * Log - 'test f1 s1 l1'
    * Log map - 'test map':
      | key1 | value1 |
      | key2 | value2 |
      | key3 | value3 |
      | key4 | value4 |
      | key5 | value5 |
    * Log dataTable - 'test datatable':
      | key1     | key2     | key3     |
      | value1_1 | value2_1 | value3_1 |
      | value1_2 | value2_2 | value3_2 |
      | value1_3 | value2_3 | value3_3 |
      | value1_4 | value2_4 | value3_4 |
      | value1_5 | value2_5 | value3_5 |