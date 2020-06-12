## SOPT 성장과제 자동로그인 :heart:
:pushpin: **SharedPreferences** 

 - 간단한 문자열을 저장하기 좋은 방식
 - 어플리케이션이 삭제되기 전까지 보존되기 전까지 1회 실행 검사를 하거나 로그인 값을 저장하기에 유용하다 
 - 데이터의 구별은 파일 이름, 키 값으로 구분된다 
 
 **AutoLogin** :exclamation:
 

    fun autoLogin(){  
    var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)  
    if(!(pref.getString("id", null).isNullOrBlank()|| pref.getString("pw",null ).isNullOrBlank())){  
        val id = pref.getString("id",null).toString()  
  
        if(!id.isNullOrBlank()){  
            Toast.makeText(this, "자동로그인", Toast.LENGTH_SHORT).show()  
            val intent = Intent(this, MainActivity::class.java)  
            startActivity(intent)  
        }  
    }  }
## ScreenShots :camera:
![autologin](https://user-images.githubusercontent.com/58849278/84543453-5e4a7a80-ad36-11ea-9489-a3472dbe9de3.gif)
