package com.example.ucanpay

import android.content.Context

object TransactionHistory {
    private const val PREFS_NAME = "TransactionPrefs"
    private const val TRANSACTION_KEY = "transactions"

    // Add a transaction
    fun addTransaction(transaction: String) {
        val sharedPreferences = MyApplication.context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val transactions = getAllTransactions().toMutableList()
        transactions.add(0, transaction) // Add to the top
        sharedPreferences.edit().putStringSet(TRANSACTION_KEY, transactions.toSet()).apply()
    }

    // Retrieve transactions (sorted)
    fun getAllTransactions(): List<String> {
        val sharedPreferences = MyApplication.context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet(TRANSACTION_KEY, emptySet())?.toList()?.sortedDescending() ?: emptyList()
    }
}
