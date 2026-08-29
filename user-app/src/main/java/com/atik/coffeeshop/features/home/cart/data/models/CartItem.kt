package com.atik.coffeeshop.features.home.cart.data.models

import com.atik.coffeeshop.features.home.explore.data.models.ItemsModel

data class CartItem(
    val item: ItemsModel,
    val quantity: Int
)
