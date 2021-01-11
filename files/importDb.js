sh.enableSharding("MovieCompany")

db.adminCommand( { shardCollection: "MovieCompany.Movie", key: { _id: "hashed" } } )

mongoimport -d=MovieCompany -c=Movie --file=csvjson_with_underscore.json --jsonArray

use MovieCompany
db.Movie.find({release_date: {$exists: true}}).forEach(function(obj) {obj.release_date = new Date(obj.release_date);db.Movie.save(obj);});
