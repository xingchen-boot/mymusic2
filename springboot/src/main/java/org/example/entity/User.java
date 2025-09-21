package***REMOVED***org.example.entity;

import***REMOVED***java.time.LocalDateTime;

/**
***REMOVED*******REMOVED***用户实体类
***REMOVED****/
public***REMOVED***class***REMOVED***User***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***username;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***password;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***nickname;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***avatar;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***updateTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Integer***REMOVED***status;***REMOVED***//***REMOVED***0-禁用***REMOVED***1-启用

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User()***REMOVED***{}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User(String***REMOVED***username,***REMOVED***String***REMOVED***password,***REMOVED***String***REMOVED***nickname)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.username***REMOVED***=***REMOVED***username;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.password***REMOVED***=***REMOVED***password;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.nickname***REMOVED***=***REMOVED***nickname;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.status***REMOVED***=***REMOVED***1;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.createTime***REMOVED***=***REMOVED***LocalDateTime.now();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.updateTime***REMOVED***=***REMOVED***LocalDateTime.now();
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***Getters***REMOVED***and***REMOVED***Setters
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Long***REMOVED***getId()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setId(Long***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.id***REMOVED***=***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getUsername()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***username;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setUsername(String***REMOVED***username)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.username***REMOVED***=***REMOVED***username;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getPassword()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***password;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setPassword(String***REMOVED***password)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.password***REMOVED***=***REMOVED***password;
***REMOVED******REMOVED******REMOVED******REMOVED***}


***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getNickname()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***nickname;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setNickname(String***REMOVED***nickname)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.nickname***REMOVED***=***REMOVED***nickname;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getAvatar()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***avatar;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setAvatar(String***REMOVED***avatar)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.avatar***REMOVED***=***REMOVED***avatar;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***LocalDateTime***REMOVED***getCreateTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCreateTime(LocalDateTime***REMOVED***createTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.createTime***REMOVED***=***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***LocalDateTime***REMOVED***getUpdateTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***updateTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setUpdateTime(LocalDateTime***REMOVED***updateTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.updateTime***REMOVED***=***REMOVED***updateTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Integer***REMOVED***getStatus()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***status;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setStatus(Integer***REMOVED***status)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.status***REMOVED***=***REMOVED***status;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***@Override
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***toString()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"User{"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"id="***REMOVED***+***REMOVED***id***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***username='"***REMOVED***+***REMOVED***username***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***nickname='"***REMOVED***+***REMOVED***nickname***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***avatar='"***REMOVED***+***REMOVED***avatar***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***createTime="***REMOVED***+***REMOVED***createTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***updateTime="***REMOVED***+***REMOVED***updateTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***status="***REMOVED***+***REMOVED***status***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'}';
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
