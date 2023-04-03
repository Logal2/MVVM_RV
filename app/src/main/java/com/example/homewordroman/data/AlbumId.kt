package com.example.homewordroman.data

import com.google.gson.annotations.SerializedName

//data class User (
//
//	@SerializedName("userId") val userId : Int,
//	@SerializedName("id") val id : Int,
//	@SerializedName("title") val title : String,
//	@SerializedName("body") val body : String
//)

data class AlbumId (
	@SerializedName("albumId") val albumId : Int,
	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("url") val url : String,
	@SerializedName("thumbnailUrl") val thumbnailUrl : String
)