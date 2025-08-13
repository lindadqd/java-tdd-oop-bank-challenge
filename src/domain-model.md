# User stories

As a customer:
- I want to create a current account.
- I want to create a savings account.
- I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.
- I want to deposit and withdraw funds.


| Classes     | Instance variables                           | Methods                                            | Scenario                                    | Output                                                                                     |
|-------------|----------------------------------------------|----------------------------------------------------|---------------------------------------------|--------------------------------------------------------------------------------------------|
| Customer    | List<Account>  accounts                      | boolean createAccount(String)                      | if customer wants to create current account | add Account to accounts and return true                                                    |
|             |                                              |                                                    | if customer wants to create savings account | add Account to accounts and return true                                                    |
|             |                                              | String generateStatement(int accountId)            | always                                      | return statement with transaction dates, amounts and balance                               |
|             |                                              | boolean withdrawFunds(int accountId, float amount) | if balance >= amount                        | return true and subtract amount from balance                                               |
|             |                                              |                                                    | if balance < amount                         | return false                                                                               |
|             |                                              | boolean depositFunds(int accountId, float amount)  | if amount > 0                               | add amount to balance and return true                                                      |
|             |                                              |                                                    | if amount < 0                               | return false                                                                               |
| ----------- |                                              |                                                    |                                             |                                                                                            |
| Account -   | - float balance                              | String generateStatement()                         | always                                      | return statement with transaction dates, amounts and balance                               |
| abstract    | - List<Transaction> transactions             | boolean withdrawFunds(float amount)                | if balance >= amount                        | subtract amount from balance, create Transaction and add to transactions list, return true |
|             | - static int nextId                          |                                                    | if balance < amount                         | return false                                                                               |
|             | - int accountId                              | boolean depositFunds(float amount)                 | if amount > 0                               | add amount to balance, create Transaction and add to transactions list and return true     |
|             |                                              |                                                    | if amount < 0                               | return false                                                                               |
|             |                                              | int getId()                                        | always                                      | return accountID                                                                           |
| ----------- |                                              |                                                    |                                             |                                                                                            |
| Savings     | -inherits methods and variables from Account |                                                    |                                             |                                                                                            |
| ----------- |                                              |                                                    |                                             |                                                                                            |
| Current     | -inherits methods and variables from Account |                                                    |                                             |                                                                                            |
| ----------- |                                              |                                                    |                                             |                                                                                            |
| Transaction | -LocalDate date                              | String generateStatement()                         | always                                      | return String transaction date, amount and balance                                         |
|             | - float amount                               |                                                    |                                             |                                                                                            |
|             | - float balance                              |                                                    |                                             |                                                                                            |
|             | -String accountType                          |                                                    |                                             |                                                                                            |



## Extensions - user stories

As an engineer,
- I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
- I want accounts to be associated with specific branches.
- I want to approve or reject overdraft requests.

As a customer,
- I want to be able to request an overdraft on my account.
- I want statements to be sent as messages to my phone.



| Classes       | Instance variables                           | Methods                                                                | Scenario                                                    | Output                                                                                     |
|---------------|----------------------------------------------|------------------------------------------------------------------------|-------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| Customer      | List<Account>  accounts                      | boolean createAccount(String)                                          | if customer wants to create current account                 | add Account to accounts and return true                                                    |
|               |                                              |                                                                        | if customer wants to create savings account                 | add Account to accounts and return true                                                    |
|               |                                              | String generateStatement(int accountId)                                | always                                                      | return statement with transaction dates, amounts and balance                               |
|               |                                              | boolean withdrawFunds(int accountId, float amount)                     | if balance >= amount                                        | return true and subtract amount from balance                                               |
|               |                                              |                                                                        | if balance < amount                                         | return false                                                                               |
|               |                                              | boolean depositFunds(int accountId, float amount)                      | if amount > 0                                               | add amount to balance and return true                                                      |
|               |                                              |                                                                        | if amount < 0                                               | return false                                                                               |
|               |                                              | List<Account> getAccounts()                                            | always                                                      | return list of accounts                                                                    |
|               |                                              | boolean requestOverdraft(Manager manager, int accountId, float amount) | if account in accounts list                                 | send request to overdraft to manager                                                       |
|               |                                              |                                                                        | if account not in accounts list                             | return false                                                                               |
|               |                                              |                                                                        |                                                             |                                                                                            |
| -----------   |                                              |                                                                        |                                                             |                                                                                            |
| Account  -    | - float balance                              | String generateStatement()                                             | always                                                      | return statement with transaction dates, amounts and balance                               |
| abstract      | - List<Transaction> transactions             | boolean withdrawFunds(float amount)                                    | if balance >= amount                                        | subtract amount from balance, create Transaction and add to transactions list, return true |
|               | - static int nextId                          |                                                                        | if balance < amount                                         | return false                                                                               |
|               | - int accountId                              | boolean depositFunds(float amount)                                     | if amount > 0                                               | add amount to balance, create Transaction and add to transactions list and return true     |
|               |                                              |                                                                        | if amount < 0                                               | return false                                                                               |
|               |                                              | int getId()                                                            | always                                                      | return accountID                                                                           |
|               |                                              | float getBalance()                                                     | always                                                      | return balance from transaction history                                                    |
|               |                                              | void withdrawFundsOverdraft(Manager manager, float amount)             | if manager not null                                         | subtract amount from balance                                                               |
|               |                                              |                                                                        | if manager null                                             |                                                                                            |
| ------------- |                                              |                                                                        |                                                             |                                                                                            |
| Savings       | -inherits methods and variables from Account |                                                                        |                                                             |                                                                                            |
| -----------   |                                              |                                                                        |                                                             |                                                                                            |
| Current       | -inherits methods and variables from Account |                                                                        |                                                             |                                                                                            |
| -----------   |                                              |                                                                        |                                                             |                                                                                            |
| Transaction   | -LocalDate date                              | String generateStatement()                                             | always                                                      | return String transaction date, amount and balance                                         |
|               | - float amount                               | String getType()                                                       | always                                                      | return type                                                                                |
|               | - float balance                              | float getAmount()                                                      | always                                                      | return amount                                                                              |
|               | -String accountType                          |                                                                        |                                                             |                                                                                            |
| ------------- |                                              |                                                                        |                                                             |                                                                                            |
| Manager       |                                              | boolean requestOverdraft(Account account, float amount)                | if account instanceof savings                               | return false                                                                               |
|               |                                              |                                                                        | if account instance of current and balance - amount <= -500 | return false                                                                               |
|               |                                              |                                                                        | if account instance of current and balance - amount >= -500 | call withdrawFundsOverdraft on account and return true                                     |
| ------------- |                                              |                                                                        |                                                             |                                                                                            |

