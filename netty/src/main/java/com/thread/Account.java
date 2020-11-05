package com.thread;

/**
 * @author dzl
 * 2020/10/29 14:51
 * @Description
 */
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account accountA = new Account(200);
        Account accountB = new Account(200);
        Account accountC = new Account(200);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                accountA.transfer(accountB, 20);
            }
        });
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                accountB.transfer(accountC, 20);
            }
        });
        thread1.start();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accountB.balance);

    }

    // 转账
    synchronized void transfer(Account target, int amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
