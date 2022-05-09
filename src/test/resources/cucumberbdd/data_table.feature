Feature: How to use data table

  Rule: There are a few ways to work with datatable

    Scenario: Data table with single row with no header
      Given my credentials is single row with no header
        | john | john123 |

    Scenario: Data table with multiple rows with no header
      Given my credentials is multiple rows with no header
        | john | john123 |
        | bill | bill123 |

    Scenario: Data table with multiple rows with no header with Datatable Type
      Given my credentials is multiple rows with no header with Datatable Type
        | john | john123 |
        | bill | bill123 |

    Scenario: Data table with single row with with header using List of List
      Given my credentials is single row with with header using List of List
        | username | password |
        | john     | john123  |

    Scenario: Data table with single row with with header using List of Map
      Given my credentials is single row with with header using List of Map
        | username | password |
        | john     | john123  |

    Scenario: Data table with multiple rows with with header using List of Map
      Given my credentials is multiple rows with with header using List of Map
        | username | password |
        | john     | john123  |
        | bill     | bill123  |

    Scenario: Data table with single row with with header using Data Table Type
      Given my credentials is single row with with header using Data Table Type
        | username | password |
        | john     | john123  |

    Scenario: Data table with multiple rows with with header using Data Table Type
      Given my credentials is multiple rows with with header using Data Table Type
        | username | password |
        | john     | john123  |
        | bill     | bill123  |

    Scenario: Data table with single column with with no header
      Given my credentials is single column with with no header
        | john    |
        | john123 |

    Scenario: Data table with single column with header using DataTable
      Given my credentials is single column with with header using DataTable
        | username | john    |
        | password | john123 |

    Scenario: Data table with single column with no header using Data Table Type
      Given my credentials is single column with no header using Data Table Type
        | john    |
        | john123 |

    Scenario: Data table with single column with header using Data Table Type
      Given my credentials is single column with header using Data Table Type
        | username | john    |
        | password | john123 |

    Scenario: Data table with multiple columns with header using Data Table Type
      Given my credentials is multiple columns with header using Data Table Type
        | username | john    | bill    |
        | password | john123 | bill123 |

