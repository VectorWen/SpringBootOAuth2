### v0.0.1


#### 授权码获取token

完成最基本的集成

http://127.0.0.1:8080/oauth/authorize?response_type=code&client_id=123&redirect_url=http://www.baidu.com&scope=all

授权成功后将会跳转

https://www.baidu.com/?code=jg2XC3

其中code 参数为授权码

发送POST 请求获取token

1. /oauth/token
2. grant_type=authorization_code
3. code=jg2XC3
4. scope=all
5. redirect_url=http://www.baidu.com
6. Authorization: Basic MTIzOjEyMzQ1Ng==

```
POST /oauth/token?grant_type=authorization_code&client_id=123&code=jg2XC3&redirect_url=http:%2F%2Fwww.baidu.com&scope=all HTTP/1.1
Authorization: Basic MTIzOjEyMzQ1Ng==
Content-Type: application/x-www-form-urlencoded; charset=utf-8
Cookie: JSESSIONID=11F16A8EA98AA7AFCF030275D1785AA6
Host: 127.0.0.1:8080
Connection: close
User-Agent: Paw/3.1.4 (Macintosh; OS X/10.13.6) GCDHTTPRequest
Content-Length: 0

```


#### 密码模式获取token

1. /oauth/token
2. grant_type=password
3. username=user
4. password=123456
5. Authorization: Basic dGVzdDoxMjM0NTY=

```
POST /oauth/token?grant_type=password HTTP/1.1
Authorization: Basic dGVzdDoxMjM0NTY=
Content-Type: application/x-www-form-urlencoded; charset=utf-8
Cookie: JSESSIONID=11F16A8EA98AA7AFCF030275D1785AA6
Host: 127.0.0.1:8080
Connection: close
User-Agent: Paw/3.1.4 (Macintosh; OS X/10.13.6) GCDHTTPRequest
Content-Length: 52

grant_type=password&username=user&password=123456

```

#### 返回结果

```
{
  "access_token": "f5fae9a9-f163-42cb-9fd2-945e80a75a94",
  "token_type": "bearer",
  "refresh_token": "367885e0-cbc6-4abf-a005-d05ca5db8faf",
  "expires_in": 7168,
  "scope": "all read write"
}
```