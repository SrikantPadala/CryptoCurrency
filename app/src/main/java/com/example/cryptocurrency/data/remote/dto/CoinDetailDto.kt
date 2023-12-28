package com.example.cryptocurrency.data.remote.dto

import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.model.TeamMember
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("description")
    val description: String?,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: List<Tag>?,
    @SerializedName("team")
    val teamMemberDto: List<TeamMemberDto>?,
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper,
)

fun CoinDetailDto.asDomainModel(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description ?: "",
        symbol = symbol ?: "",
        rank = rank,
        isActive = isActive,
        tags = tags?.map { it.name } ?: emptyList(),
        teamMembers = teamMemberDto?.map { it.asDomainModel() } ?: emptyList(),
    )
}

fun TeamMemberDto.asDomainModel(): TeamMember {
    return TeamMember(
        id = id,
        name = name,
        position = position,
    )
}
