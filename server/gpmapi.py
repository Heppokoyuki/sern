#!/usr/bin/python
from gmusicapi import Webclient

f= open('.mailpass.txt')
text = f.read()
line = text.split('\n')
email_tex = line[0]
pass_tex = line[1]

api = Webclient()
var = api.login(email_tex,pass_tex)
print(var)

#library = api.get_all_songs()

#sweet_track_ids = [track['id'] for track in library
#                   if track['artist'] == 'The Cat Empire']

#playlist_id = api.create_playlist('Rad muzak')
#api.add_songs_to_playlist(playlist_id, sweet_track_ids)
#print(library)
