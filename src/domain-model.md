# User stories

As a customer:
- I want to create a current account.
- I want to create a savings account.
- I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
- I want to deposit and withdraw funds.


| Classes     | Instance variables                           | Methods                                      | Scenario                                    | Output                                                                                     |
|-------------|----------------------------------------------|----------------------------------------------|---------------------------------------------|--------------------------------------------------------------------------------------------|
| Customer    | List<Account>  accounts                      | boolean createAccount(String)                | if customer wants to create current account | add Account to accounts and return true                                                    |
|             |                                              |                                              | if customer wants to create savings account | add Account to accounts and return true                                                    |
|             |                                              | String generateStatement(Account)            | always                                      | return statement with transaction dates, amounts and balance                               |
|             |                                              | boolean withdrawFunds(Account, float amount) | if balance >= amount                        | return true and subtract amount from balance                                               |
|             |                                              |                                              | if balance < amount                         | return false                                                                               |
|             |                                              | boolean depositFunds(Account, float amount)  | if amount > 0                               | add amount to balance and return true                                                      |
|             |                                              |                                              | if amount < 0                               | return false                                                                               |
| ----------- |                                              |                                              |                                             |                                                                                            |
| Account -   | - float balance                              | String generateStatement (transactions)      | always                                      | return statement with transaction dates, amounts and balance                               |
| abstract    | - List<Transaction> transactions             | boolean withdrawFunds(float amount)          | if balance >= amount                        | subtract amount from balance, create Transaction and add to transactions list, return true |
|             | - static int nextId                          |                                              | if balance < amount                         | return false                                                                               |
|             | - int accountId                              | boolean depositFunds(float amount)           | if amount > 0                               | add amount to balance, create Transaction and add to transactions list and return true     |
|             |                                              |                                              | if amount < 0                               | return false                                                                               |
|             |                                              | int getId()                                  | always                                      | return accountID                                                                           |
| ----------- |                                              |                                              |                                             |                                                                                            |
| Savings     | -inherits methods and variables from Account |                                              |                                             |                                                                                            |
| ----------- |                                              |                                              |                                             |                                                                                            |
| Current     | -inherits methods and variables from Account |                                              |                                             |                                                                                            |
| ----------- |                                              |                                              |                                             |                                                                                            |
| Transaction | -LocalDate date                              | String generateStatement()                   | always                                      | return String transaction date, amount and balance                                         |
|             | - float amount                               |                                              |                                             |                                                                                            |
|             | - float balance                              |                                              |                                             |                                                                                            |
|             | -String accountType                          |                                              |                                             |                                                                                            |