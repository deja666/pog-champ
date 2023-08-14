 package org.pogchamp.lolchampions.presentation.util

object UrlHelper {
    const val BASE_URL = "http://ddragon.leagueoflegends.com/cdn"
    const val LOL_VERSION = "12.6.1"
}

fun getChampionImageUrl(name: String?) =
    if (!name.isNullOrEmpty()) "${UrlHelper.BASE_URL}/img/champion/splash/${name}_0.jpg"
    else null

fun getSpellImageUrl(name: String?) =
    if (!name.isNullOrEmpty()) "${UrlHelper.BASE_URL}/${UrlHelper.LOL_VERSION}/img/spell/${name}.png"
    else null

fun getPassiveImageUrl(fileName: String?) =
    if (!fileName.isNullOrEmpty()) "${UrlHelper.BASE_URL}/${UrlHelper.LOL_VERSION}/img/passive/${fileName}"
    else null

fun getSkinImageUrl(name: String, skinNum: Int) =
    "${UrlHelper.BASE_URL}/img/champion/loading/${name}_${skinNum}.jpg"