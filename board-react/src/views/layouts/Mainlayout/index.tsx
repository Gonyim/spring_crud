import React from 'react'
import Box from '@mui/material/Box'
import Navigation from '../../Navigation'

export default function MainLayout() {
  return (
    <>
        <Navigation />
        <Box display='flex'>
            <Box flex={1} display='flex' justifyContent={'center'} alignItems={'center'}>

            </Box>
            <Box flex={1}></Box>
        </Box>
    </>
  )
}
