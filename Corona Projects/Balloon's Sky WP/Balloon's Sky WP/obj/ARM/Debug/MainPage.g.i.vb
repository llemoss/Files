﻿#ExternalChecksum("C:\Users\Gildásio Zeth\Google Drive\Documents\Corona Projects\Balloon's Sky WP\Balloon's Sky WP\MainPage.xaml","{406ea660-64cf-4c82-b6f0-42d48172a799}","F1D605D5B7E066B53ADC46A84757BD05")
'------------------------------------------------------------------------------
' <auto-generated>
'     This code was generated by a tool.
'     Runtime Version:4.0.30319.42000
'
'     Changes to this file may cause incorrect behavior and will be lost if
'     the code is regenerated.
' </auto-generated>
'------------------------------------------------------------------------------

Option Strict Off
Option Explicit On

Imports CoronaLabs.Corona.WinRT.Phone
Imports Microsoft.Phone.Controls
Imports System
Imports System.Windows
Imports System.Windows.Automation
Imports System.Windows.Automation.Peers
Imports System.Windows.Automation.Provider
Imports System.Windows.Controls
Imports System.Windows.Controls.Primitives
Imports System.Windows.Data
Imports System.Windows.Documents
Imports System.Windows.Ink
Imports System.Windows.Input
Imports System.Windows.Interop
Imports System.Windows.Markup
Imports System.Windows.Media
Imports System.Windows.Media.Animation
Imports System.Windows.Media.Imaging
Imports System.Windows.Resources
Imports System.Windows.Shapes
Imports System.Windows.Threading



<Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>  _
Partial Public Class MainPage
    Inherits Microsoft.Phone.Controls.PhoneApplicationPage
    
    Friend WithEvents fDrawingSurfaceBackgroundGrid As System.Windows.Controls.DrawingSurfaceBackgroundGrid
    
    Friend WithEvents fCoronaPanel As CoronaLabs.Corona.WinRT.Phone.CoronaPanel
    
    Private _contentLoaded As Boolean
    
    '''<summary>
    '''InitializeComponent
    '''</summary>
    <System.Diagnostics.DebuggerNonUserCodeAttribute()>  _
    Public Sub InitializeComponent()
        If _contentLoaded Then
            Return
        End If
        _contentLoaded = true
        System.Windows.Application.LoadComponent(Me, New System.Uri("/Balloon's%20Sky%20WP;component/MainPage.xaml", System.UriKind.Relative))
        Me.fDrawingSurfaceBackgroundGrid = CType(Me.FindName("fDrawingSurfaceBackgroundGrid"),System.Windows.Controls.DrawingSurfaceBackgroundGrid)
        Me.fCoronaPanel = CType(Me.FindName("fCoronaPanel"),CoronaLabs.Corona.WinRT.Phone.CoronaPanel)
    End Sub
End Class
