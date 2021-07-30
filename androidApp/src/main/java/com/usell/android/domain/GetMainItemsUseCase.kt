package com.usell.android.domain

import com.rasalexman.sresult.domain.IUseCase
import com.usell.android.models.MainItemUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import kotlin.random.Random

class GetMainItemsUseCase : IGetMainItemsUseCase {
    override fun invoke(): Flow<List<MainItemUI>> {
        return flow {
            val randomCount = Random.nextInt(50, 200)
            val range = 1..randomCount
            val items = range.map { pos ->
                val randomDescLength = Random.nextInt(10, 26)
                MainItemUI(
                    position = pos,
                    title = "Item #$pos",
                    description = UUID.randomUUID().toString().takeLast(randomDescLength)
                )
            }
            emit(items)
        }.flowOn(Dispatchers.Default)
    }
}

interface IGetMainItemsUseCase : IUseCase.FlowOut<List<MainItemUI>>