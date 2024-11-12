import React, {useEffect, useState} from 'react'
import { listMedia } from '../services/MediaService'

const ListMediaComponent = () => {

    const [media, setMedia] = useState([])

    useEffect(() => {
        listMedia().then((response) => {
            setMedia(response.data);
        }).catch(error => {
            console.error(error)
        })

    }, [])

  return (
    <div className='container'>
        <h2>Directory</h2>
        <table className='table table-striped'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Year</th>
                </tr>
            </thead>
            <tbody>
                {
                    media.map(media =>
                        <tr key={media.id}>
                            <td>{media.id}</td>
                            <td>{media.author}</td>
                            <td>{media.title}</td>
                            <td>{media.year}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListMediaComponent