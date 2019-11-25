package ar.edu.unq.ingdesoftware.model

class User (var id: Int, var username: String, var password: String) {

    fun setUserName(newUserName: String){
        username = newUserName;
    }

}
