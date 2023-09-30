package com.omrilhn.eventifyappalpha.core.presentation.personal_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.omrilhn.eventifyappalpha.core.domain.models.Category
import com.omrilhn.eventifyappalpha.presentation.personal_detail.PersonalDetailViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorizedLazyColumn(
    categories:List<Category>,
    modifier : Modifier = Modifier,
    personalDetailViewModel: PersonalDetailViewModel = hiltViewModel()
){
    LazyColumn(modifier){
        categories.forEach{category ->
            stickyHeader { //For header that highlights categoryName
                CategoryHeader(text = category.name) // Show category name
            }
            //Get every single item of category
            items(category.items){text->
                CategoryItem(text = text)

            }
        }
    }

}