package `in`.nehalpatel.sdjickotlin

class Contact {
    var _id = 0
    var _name: String?
    var _phone_number: String?

    init {
        _id = 0
        _name= null
        _phone_number = null
    }

    constructor(){ }

    constructor(id: Int, name: String?, _phone_number: String?) {
        _id = id
        _name = name
        this._phone_number = _phone_number
    }

    constructor(name: String?, _phone_number: String?) {
        _name = name
        this._phone_number = _phone_number
    }

    fun getID(): Int {
        return _id
    }

    fun setID(id: Int) {
        _id = id
    }

    fun getName(): String? {
        return _name
    }

    fun setName(name: String?) {
        _name = name
    }

    fun getPhoneNumber(): String? {
        return _phone_number
    }

    fun setPhoneNumber(phone_number: String?) {
        _phone_number = phone_number
    }
}
