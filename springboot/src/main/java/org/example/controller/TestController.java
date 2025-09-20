package***REMOVED***org.example.controller;

import***REMOVED***org.springframework.web.bind.annotation.GetMapping;
import***REMOVED***org.springframework.web.bind.annotation.RequestMapping;
import***REMOVED***org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public***REMOVED***class***REMOVED***TestController***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/hello")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***hello()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"Hello,***REMOVED***MyMusic***REMOVED***Spring***REMOVED***Boot***REMOVED***Application***REMOVED***is***REMOVED***running!";
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***home()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"Welcome***REMOVED***to***REMOVED***MyMusic***REMOVED***API!***REMOVED***Ready***REMOVED***for***REMOVED***your***REMOVED***implementation.";
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
