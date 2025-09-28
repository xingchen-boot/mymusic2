/**
 * 移动端检测和响应式工具函数
 */

// 检测是否为移动设备
export const isMobile = (): boolean => {
  return window.innerWidth <= 768
}

// 检测是否为平板设备
export const isTablet = (): boolean => {
  return window.innerWidth > 768 && window.innerWidth <= 1024
}

// 检测是否为桌面设备
export const isDesktop = (): boolean => {
  return window.innerWidth > 1024
}

// 获取当前设备类型
export const getDeviceType = (): 'mobile' | 'tablet' | 'desktop' => {
  if (isMobile()) return 'mobile'
  if (isTablet()) return 'tablet'
  return 'desktop'
}

// 监听窗口大小变化
export const onResize = (callback: (deviceType: 'mobile' | 'tablet' | 'desktop') => void) => {
  const handleResize = () => {
    callback(getDeviceType())
  }
  
  window.addEventListener('resize', handleResize)
  
  // 返回清理函数
  return () => {
    window.removeEventListener('resize', handleResize)
  }
}

// 移动端触摸检测
export const isTouchDevice = (): boolean => {
  return 'ontouchstart' in window || navigator.maxTouchPoints > 0
}

// 获取安全区域（用于刘海屏适配）
export const getSafeAreaInsets = () => {
  const style = getComputedStyle(document.documentElement)
  return {
    top: parseInt(style.getPropertyValue('--safe-area-inset-top') || '0'),
    right: parseInt(style.getPropertyValue('--safe-area-inset-right') || '0'),
    bottom: parseInt(style.getPropertyValue('--safe-area-inset-bottom') || '0'),
    left: parseInt(style.getPropertyValue('--safe-area-inset-left') || '0')
  }
}

