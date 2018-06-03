# JSON diff

This project shows how [zjsonpatch](https://github.com/flipkart-incubator/zjsonpatch) and [json-unit](https://github.com/lukas-krecan/JsonUnit) compares JSON files

### Output

`zjsonpatch`

> java.lang.AssertionError: {"op":"replace","fromValue":"Joe Doe","path":"/1/friends/2/name","value":"Colon Frost"}  
> {"op":"move","from":"/2/friends/0/email","path":"/4/email"}  
> {"op":"remove","path":"/2/friends/3","value":{"id":3,"name":"Extra ball"}}  
> {"op":"add","path":"/2/phone","value":"+1 (942) 599-3505"}  


`json-unit`

> java.lang.AssertionError: JSON documents are different:  
> Different value found in node "[1].friends[2].name", expected: <"Colon Frost"> but was: <"Joe Doe">.  
> Different keys found in node "[2]", expected: <[_id, about, address, age, balance, company, email, eyeColor, favoriteFruit, friends, gender, greeting, guid, index, isActive, latitude, longitude, name, phone, picture, registered, tags]> but was: <[_id, about, address, age, balance, company, email, eyeColor, favoriteFruit, friends, gender, greeting, guid, index, isActive, latitude, longitude, name, picture, registered, tags]>. Missing: "[2].phone"   
> Array "[2].friends" has different length, expected: <3> but was: <4>.  
> Different keys found in node "[2].friends[0]", expected: <[id, name]> but was: <[email, id, name]>.  Extra: "[2].friends[0].email"  
> Different keys found in node "[4]", expected: <[_id, about, address, age, balance, company, email, eyeColor, favoriteFruit, friends, gender, greeting, guid, index, isActive, latitude, longitude, name, phone, picture, registered, tags]> but was: <[_id, about, address, age, balance, company, eyeColor, favoriteFruit, friends, gender, greeting, guid, index, isActive, latitude, longitude, name, phone, picture, registered, tags]>. Missing: "[4].email"   
