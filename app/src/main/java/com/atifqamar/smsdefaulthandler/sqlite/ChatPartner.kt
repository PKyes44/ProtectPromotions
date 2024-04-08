package com.atifqamar.smsdefaulthandler.sqlite

import java.io.Serializable

class ChatPartner(
    var id: String,
    var name: String
): Serializable {
    constructor(): this("","")
}