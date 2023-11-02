# Feature: Validationg place API's

| name | language | address|
| arvind | English| east avenue |
| rahul  | Hindi | west avenue |
| vijay  | Marathi | south avenue |

## Verify if place is being successfully added using AddPlaceAPI
tags: AddPlace
*   Add place payload <name> <language> <address>
*	user calls "AddPlaceAPI" with "Post" http request
*	the API call got success with status code "200"
*	"status" in response body is "OK"
*	"scope" in response body is "APP"
*	verify place_Id created maps to <name> using "getPlaceAPI"

## Verify if delete place functionmality is working
tags: DeletePlace
*	DeletePlace Payload
*	user calls "deletePlaceAPI" with "Post" http request
*	the API call got success with status code "200"
*	"status" in response body is "OK"

