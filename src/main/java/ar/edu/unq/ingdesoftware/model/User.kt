package ar.edu.unq.ingdesoftware.model

class User (var id: Int, var username: String, var password: String) {

    private constructor(): this(0, "", "");

    fun setUserName(newUserName: String){
        username = newUserName;
    }

}
