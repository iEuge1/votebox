/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
#ifndef VBWRAPPER
#define VBWRAPPER 1

#include "SDL.h"

/**
 *  Direct wrappers for SDL functions
 */
int vbSDL_Init(int flags);
void vbSDL_Quit(void);
SDL_Surface* vbSDL_SetVideoMode(int width, int height, int bitsperpixel, int flags);
SDL_Surface* vbSDL_LoadBMP(char* file_name);
int vbSDL_SetColors(SDL_Surface* surface, SDL_Color* colors, int firstcolor, int ncolors);
int vbSDL_BlitSurface(SDL_Surface* src, SDL_Rect* srcrect, SDL_Surface* dst, SDL_Rect* dstrect);
void vbSDL_UpdateRect(SDL_Surface* screen, int x, int y, int w, int h);
void vbSDL_FreeSurface(SDL_Surface* surface);
int vbSDL_WaitEvent(SDL_Event *event);
void vbSDL_SetClipRect(SDL_Surface *surface, SDL_Rect *rect);
int vbSDL_FillRect(SDL_Surface *dst, SDL_Rect *dstrect, int color);
void vbSDL_GetClipRect(SDL_Surface *surface, SDL_Rect *rect);
SDL_Surface* vbSDL_ConvertSurface(SDL_Surface *src, SDL_PixelFormat *fmt, int flags);

/**
 * Wrappers for relatively complex combinations of SDL functions
 */
int Enabled_Elo_Touchscreen(char* device_path);

/**
 *  Helpers for dealing with complex SDL data types from java code.
 */
int Event_Get_Type(SDL_Event *event);
int Event_Get_Mouse_X(SDL_Event *event);
int Event_Get_Mouse_Y(SDL_Event *event);
int Event_Get_Mouse_Button(SDL_Event *event);
int Event_Get_Key(SDL_Event *event);
void Rect_Set(SDL_Rect* rect, int x, int y,int w, int h);
int Rect_Get_X(SDL_Rect* rect);
int Rect_Get_Y(SDL_Rect* rect);
int Rect_Get_Width(SDL_Rect* rect);
int Rect_Get_Height(SDL_Rect* rect);
int Surface_Set_Pixel(int x, int y, SDL_Surface* surface, int a, int r, int g, int b);
int Surface_Get_Pixel_R(int x, int y, SDL_Surface* surface);
int Surface_Get_Pixel_G(int x, int y, SDL_Surface* surface);
int Surface_Get_Pixel_B(int x, int y, SDL_Surface* surface);
int Surface_Get_Pixel_A(int x, int y, SDL_Surface* surface);
SDL_PixelFormat* Surface_Get_Format(SDL_Surface* surface);

/**
 * Alloc/free pairs for various SDL data types
 */
SDL_Surface* Alloc_Surface(int width, int height);
SDL_Event* Alloc_Event();
void Free_Event(SDL_Event*);
SDL_Rect* Alloc_Rect();
void Free_Rect(SDL_Rect*);

#endif
