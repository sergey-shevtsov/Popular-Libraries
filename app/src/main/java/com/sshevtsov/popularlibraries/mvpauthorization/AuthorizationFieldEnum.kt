package com.sshevtsov.popularlibraries.mvpauthorization

enum class AuthorizationFieldEnum(val regex: Regex) {
    LOGIN(Regex("[A-Za-z0-9@_$]+")),
    PASSWORD(Regex("[A-Za-z0-9!@$+_*#-]+"))
}