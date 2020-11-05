package com.thread;

/**
 * @author dzl
 * 2020/10/29 15:07
 * @Description
 */
public class AccountDead {
    private int balance;

    public AccountDead(int balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        AccountDead accountDead1 = new AccountDead(200);
        AccountDead accountDead2 = new AccountDead(200);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                accountDead1.transfer(accountDead2, 10);
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                accountDead2.transfer(accountDead1, 10);

            }
        });
        thread.start();
        thread1.start();

    }

    // 转账
    void transfer(AccountDead target, int amt) {
        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }

            }
        }
    }
}
